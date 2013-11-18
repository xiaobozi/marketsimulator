package object NameTable {

    case class Impl(functions : Map[String, AST.FunDef]) {

        override def toString = functions mkString "\r\n"

        def getFunDef(name : AST.QualifiedName) : AST.FunDef = getFunDef(name.toString)

        def getFunDef(name : String) : AST.FunDef = {
            functions get name match {
                case Some(x) => x
                case None => throw new Exception(s"Cannot find name $name")
            }
        }
    }

    def create(p : List[AST.Definitions])  =
    {
        val grouped = p flatMap { _.definitions groupBy { case x : AST.FunDef => x.name } }

        val res = (grouped flatMap {
            case (name, d :: Nil) => Some(name -> d.asInstanceOf[AST.FunDef])
            case (name, lst) =>
                println(s"Duplicate definitions for $name:")
                println(lst.mkString("\r\n"))
                None
        }).toMap

        Impl(res)
    }

}