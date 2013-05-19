package streams

import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val level ="""ST
      |oo
      |oo""".stripMargin                          //> level  : String = ST
                                                  //| oo
                                                  //| oo
      
  level.split("\n")                               //> res0: Array[String] = Array(ST, oo, oo)
  
  (level.split("\n").map(x => Vector(x.map(z => z)))).toVector
                                                  //> res1: Vector[scala.collection.immutable.Vector[String]] = Vector(Vector(ST),
                                                  //|  Vector(oo), Vector(oo))
  
  
  var l = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'))
                                                  //> l  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Cha
                                                  //| r]] = Vector(Vector(S, T), Vector(o, o), Vector(o, o))
	val x = 1                                 //> x  : Int = 1
	val y = 4                                 //> y  : Int = 4
	
  
}