package object AST {

    val crlf = "\r\n"

    abstract class Type

    case class SimpleType(name : String) extends Type
    {
        override def toString = name
    }

    case object UnitType extends Type
    {
        override def toString = "()"
    }

    case class TupleType(types : List[Type]) extends Type
    {
        assert(types.length > 1) // SimpleType or UnitType should be used in this case
        // we don't want to differentiate 1-tuple and SimpleType
        override def toString = "(" + types.mkString(",") + ")"
    }

    case class FunctionType(arg_type : Type, ret_type : Type) extends Type
    {
        override def toString = s"$arg_type => $ret_type"
    }

    case class Parameter(name        : String,
                         ty          : Option[Type],
                         initializer : Option[Expr],
                         annotations : List[Annotation])
    {
        override def toString = (annotations.map({ _ + " "}).mkString("")
                + name
                + (if (ty.nonEmpty) " : " + ty.get else "")
                + (if (initializer.nonEmpty) " = " + initializer.get else ""))
    }

    case class QualifiedName(names   : List[String])
    {
        override def toString = names.mkString(".")
    }

    case class Annotation(name       : QualifiedName,
                          parameters : List[String])
    {
        override def toString = "@" + name + "(" + parameters.map({ "\"" + _ + "\""}).mkString(", ") + ")"
    }

    case class DocString(brief : String, detailed : String)
    {
        override def toString = "/** " + brief + detailed.lines.map({ crlf + " *" + _ }).mkString("") + crlf + " */" + crlf
    }

    case class FunDef(name           : String,
                      parameters     : List[Parameter],
                      body           : Option[Expr],
                      docstring      : Option[DocString],
                      annotations    : List[Annotation])
    {
        val crlf = "\r\n"

        override def toString = ((if (docstring.nonEmpty) docstring.get else "")
                + annotations.map({_ + crlf}).mkString("")
                + "def " + name
                + "(" + parameters.mkString(", ") + ")"
                + (if (body.nonEmpty) " = " + body.get else ""))

        def python = {
            lazy val parameters_float = parameters.map({
                case Parameter(n, Some(SimpleType("Float")), Some(Const(d)), _) => (n, d)
            })

            lazy val (label, comment) = docstring match {
                case Some(DocString(brief, detailed)) => (brief, detailed)
                case _ => ("","")
            }

            annotations.find({ _.name.toString == "python.random" }) match {
                case Some(_) => Some(PyGen.ImportRandom(name, parameters_float, label, comment))
                case None => annotations.find({ _.name.toString == "python.mathops" }) match {
                    case Some(Annotation(_, category :: impl :: label_tmpl :: Nil)) => {
                        Some(PyGen.ImportMathops(name, category, impl, Some(label_tmpl), parameters_float, comment))
                    }
                    case _ => None
                }
            }
        }
    }

    case class Definitions(definitions : List[FunDef]) {
        override def toString = definitions.map({_ + crlf + crlf}).mkString("")

        def python = definitions.map({ _.python })
    }

    sealed abstract class BinOpSymbol(symbol : String, p : Int) {
        override val toString = symbol
        val priority = p
    }
    case class Add() extends BinOpSymbol("+", 2)
    case class Sub() extends BinOpSymbol("-", 2)
    case class Mul() extends BinOpSymbol("*", 1)
    case class Div() extends BinOpSymbol("/", 1)

    sealed abstract class Expr(p : Int) {

        val priority  = p

        def need_brackets(x : Expr, rhs : Boolean = false) =
            x.priority > priority || x.priority == priority && rhs

        def wrap_if_needed(x : Expr, rhs : Boolean = false) =
            if (need_brackets(x,rhs)) parens(x.toString) else x.toString

        def parens(x : String) = "(" + x + ")"
    }

    case class Const(value: Double) extends Expr(0) {
        override val toString = value.toString
    }
    case class Var(s : String) extends Expr(0) {
        override val toString = s
    }
    case class BinOp(symbol : BinOpSymbol, x: Expr, y: Expr) extends Expr(symbol.priority) {
        override def toString = wrap_if_needed(x) + symbol + wrap_if_needed(y, rhs = true)
    }

    case class Neg(x: Expr) extends Expr(0) {
        override def toString = "-" + wrap_if_needed(x)
    }

    case class IfThenElse(cond : BooleanExpr, x : Expr, y : Expr) extends Expr(3) {
        override def toString = s"if $cond then ${wrap_if_needed(x)} else ${wrap_if_needed(y)}"
    }
    case class FunCall(name : QualifiedName, args : List[Expr]) extends Expr(0) {
        override def toString = name.toString + parens(args.map(_.toString).mkString(","))
    }

    sealed abstract class CondSymbol(symbol : String) {
        override val toString = symbol
    }

    case class Less() extends CondSymbol("<")
    case class LessEqual() extends CondSymbol("<=")
    case class Greater() extends CondSymbol(">")
    case class GreaterEqual() extends CondSymbol(">=")
    case class Equal() extends CondSymbol("=")
    case class NotEqual() extends CondSymbol("<>")

    sealed abstract class BooleanExpr

    case class Condition(symbol : CondSymbol, x : Expr, y : Expr) extends BooleanExpr {
        override def toString = x.toString + symbol + y
    }

    case class Or   (x : BooleanExpr, y : BooleanExpr) extends BooleanExpr {
        override def toString = x + " or " + y
    }

    case class And  (x : BooleanExpr, y : BooleanExpr) extends BooleanExpr
    {
        override def toString = wrap_if_needed(x) + " and " + wrap_if_needed(y)

        def wrap_if_needed(x : BooleanExpr) = x match {
            case z : Or => "(" + z + ")"
            case z => z.toString
        }
    }

    case class Not  (x : BooleanExpr) extends BooleanExpr
    {
        override def toString = "not " +  wrap_if_needed(x)

        def wrap_if_needed(x : BooleanExpr) = x match {
            case Condition(_,_,_) => x.toString
            case _ => "(" + x + ")"
        }
    }

}
