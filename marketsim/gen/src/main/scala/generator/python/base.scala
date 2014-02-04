package generator.python

import predef.PyPrintable
import predef._
import predef.Import
import predef.ImportFrom
import scala.Some

package object base {

    val tab = "    "
    val comma = ","

    abstract class Class extends gen.GenerationUnit
    {
        def name : String
        def body : Code
        def registration : Code
        def base_class : Code = "object"
        def base_classes = base_class

        def code = withImports(registration | s"class $name(" ||| base_classes ||| "):" |> body)
    }

    def decoratedName(f : Typed.Function) =
        f.name + "_" +
                (f.parameters map { p =>
                    "[].()=> ,".toList.foldLeft(p.ty.toString){case (z, s) => z.replace(s.toString, "_")}
                } mkString "__")


    def withImports(code: => predef.Code) : Code =
        new WithoutImports((code.imports map { _.repr + crlf } mkString "") + code)

    abstract class Parameter {

        val p : Typed.Parameter

        def name = p.name
        def ty = p.ty.asCode
        def initializer = p.initializer
        def s_initializer = if (initializer.nonEmpty) "= None" else ""

        def init = s"$name $s_initializer"
        def init_raw = name
        def assign =  s"self.$name = $name" ||| assign_if_none

        def assign_if_none: predef.Code =
            initializer match {
                case Some(x) => s" if $name is not None else " ||| x.asCode
                case None => ""
            }

        def property = s"\'$name\' : " ||| ty
        def repr = s"%($name)s"
        def call = s"self.$name"
    }

    def Def(name : String, args : Code, body : Code) = {
        val a = if (args.toString == "") "" else ", " + args
        s"def $name(self$a):" |>
                (if (body.isInstanceOf[predef.Stop]) "pass" else withImports(body)) |
        ""
    }

    def Prop(name : String, body : Code) =
        "@property" |
        s"def $name(self):" |> body | ""


    abstract class Printer extends Class {
        type Parameter <: base.Parameter
        val f           : Typed.Function
        def name        : String
        def docstring   : List[String]
        def alias       : String
        def category    = f.getAttribute("category")
        def parameters  : List[Parameter]
        def registration =
            if (parameters exists { _.p.initializer.isEmpty })
                ""
            else
                s"""@registry.expose(["$category", "$alias"])""" ||| ImportFrom("registry", "marketsim")

        def join_fields(p           : Parameter => Code,
                        sep         : Code = ", ",
                        elements    : List[Parameter] = parameters) : Code
            =   Code.from(elements map p, sep)

        def init_fields = join_fields({ _.init })
        def init_raw_fields = join_fields({ _.init_raw })
        def assign_fields = join_fields({ _.assign }, nl)
        def property_fields = join_fields({ _.property }, comma + nl)
        def repr_fields = join_fields({ _.repr })
        def call_fields = join_fields({ _.call })

        def impl_function = name

        def doc = s"""\"\"\" ${docstring.mkString(crlf)}$crlf\"\"\" """

        def init_body = assign_fields | "rtti.check_fields(self)" ||| ImportFrom("rtti", "marketsim")

        def init = Def("__init__", init_fields, init_body)

        def label = Prop("label", "return repr(self)")

        def label_tmpl : Code = f.tryGetAttribute("label") match {
            case Some(x) => x
            case None => alias ||| (if (parameters.isEmpty) "" else s"($repr_fields)")
        }


        def properties = "_properties = {" |> property_fields | "}"

        def repr_body : Code = s"""return "$label_tmpl" % self.__dict__"""

        def repr = Def("__repr__", "", repr_body)

        def call_body : Code = ""
        def call_args : Code = "*args, **kwargs"
        def call = Def("__call__", call_args, call_body)

        def body = doc | init | label | properties | repr
    }

    trait DocString {
        def f : Typed.Function

        val docstring  = f.docstring match {
            case Some(d) => d.detailed
            case None => Nil
        }
    }

    abstract class Intrinsic extends Printer
    {
        def impl_module : String

        override def call_body : Code = s"""return $impl_module.$impl_function($call_fields)""" ||| Import(impl_module)
    }

    object python extends gen.PythonGenerator
    {
        val name = "python"

        def generatePython(/** arguments of the annotation */ args  : List[String])
                          (/** function to process         */ f     : Typed.Function) =
        {
            (if (TypesBound.isObservable(f.ret_type)) observable
                else if (TypesBound.isStrategy(f.ret_type))
                    strategy
                else
                    function).generatePython(args)(f)
        }
    }

}
