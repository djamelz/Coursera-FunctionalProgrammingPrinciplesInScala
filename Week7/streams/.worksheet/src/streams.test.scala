package streams

import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(139); 
  println("Welcome to the Scala worksheet");$skip(57); 
  
  val level ="""ST
      |oo
      |oo""".stripMargin;System.out.println("""level  : String = """ + $show(level ));$skip(27); val res$0 = 
      
  level.split("\n");System.out.println("""res0: Array[String] = """ + $show(res$0));$skip(66); val res$1 = 
  
  (level.split("\n").map(x => Vector(x.map(z => z)))).toVector;System.out.println("""res1: Vector[scala.collection.immutable.Vector[String]] = """ + $show(res$1));$skip(77); 
  
  
  var l = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'));System.out.println("""l  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(l ));$skip(11); 
	val x = 1;System.out.println("""x  : Int = """ + $show(x ));$skip(11); 
	val y = 4;System.out.println("""y  : Int = """ + $show(y ))}
	
  
}
