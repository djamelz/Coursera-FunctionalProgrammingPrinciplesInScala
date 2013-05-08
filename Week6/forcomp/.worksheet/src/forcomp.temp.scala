package forcomp



object temp {
  type Occurrences = List[(Char, Int)];import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(115); 
  println("Welcome to the Scala worksheet");$skip(165); 
  def wordOccurrences(w: String): Occurrences =
    w.toLowerCase().groupBy((element: Char) => element).map{case (c, s) => (c, s.length)}.toList.sortBy((x) => x._1);System.out.println("""wordOccurrences: (w: String)forcomp.temp.Occurrences""");$skip(94); val res$0 = 
  
  
  ("abcd".groupBy((element: Char) => element).map{case (c, s) => (c, s.length)}).toList;System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(32); val res$1 = 
  
  List("a","b","c").mkString;System.out.println("""res1: String = """ + $show(res$1));$skip(78); 
  
  val occur = List("eat", "ate","tub").map( x => ( wordOccurrences(x), x));System.out.println("""occur  : List[(forcomp.temp.Occurrences, String)] = """ + $show(occur ));$skip(90); val res$2 = 
  
  occur.groupBy{ case (x,y) => x }.map{case(x,y) => x -> y.map{case(a,b) => b}}.toList;System.out.println("""res2: List[(forcomp.temp.Occurrences, List[String])] = """ + $show(res$2));$skip(71); 
  
  
    
    val lard = List(('a', 3), ('d', 1), ('l', 1), ('r', 1));System.out.println("""lard  : List[(Char, Int)] = """ + $show(lard ));$skip(36); 
    val r = List(('a', 2),('r', 2));System.out.println("""r  : List[(Char, Int)] = """ + $show(r ));$skip(125); val res$3 = 
    
    lard.map{
      case(z) => if (z._1 == r.head._1) (z._1, z._2 - r.head._2) else z
      }.filter(p => !(p._2 == 0));System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3));$skip(136); val res$4 = 

    
    lard.map{
      case(z) => if ((r.exists(rr => z._1 == rr._1)) == None) (z._1, z._2) else z
      }.filter(p => !(p._2 == 0));System.out.println("""res4: List[(Char, Int)] = """ + $show(res$4));$skip(248); 
     
   def subtract(x: Occurrences, y: Occurrences): Occurrences = {
    (y.toMap.foldLeft(x.toMap) ((xx, yy) => {
      val count = xx(yy._1) - yy._2
      if (count <= 0) xx - yy._1
      else xx.updated(yy._1, count)
    })).toList.sorted
  };System.out.println("""subtract: (x: forcomp.temp.Occurrences, y: forcomp.temp.Occurrences)forcomp.temp.Occurrences""");$skip(19); val res$5 = 
  subtract(lard,r);System.out.println("""res5: forcomp.temp.Occurrences = """ + $show(res$5))}
}
