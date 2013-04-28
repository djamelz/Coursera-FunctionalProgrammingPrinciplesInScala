package patmat

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t0 = Leaf('a', 2)
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }
  
  test("weight of leaf") {
    new TestTrees {
      assert(weight(t0) === 2)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }
  
  test("chars of leaf") {
    new TestTrees {
      assert(chars(t0) === List('a'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }
  
  test("times several") {
      val actual = times(string2Chars("aaabcab"))
      assert(actual.size == 3)
      assert(actual.exists(p => p._1 == 'a' && p._2 == 4))
      assert(actual.exists(p => p._1 == 'b' && p._2 == 2))
      assert(actual.exists(p => p._1 == 'c' && p._2 == 1))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }
  
  test("until"){
    assert(until(singleton, combine)(List(Leaf('e',1), Leaf('t',2), Leaf('x',3))) == List(Fork(Fork(Leaf('e',1), Leaf('t', 2), List('e', 't'), 3), Leaf('x',3), List('e', 't', 'x'), 6)))
  }
  
  test("huge test"){
    val frenchFreq: List[(Char, Int)] = List(('e', 225947), ('s', 121895), ('a', 117110), ('i', 115465), ('t', 111103), 
      ('n', 108812), ('r', 100500), ('u', 96785), ('l', 83668), ('o', 82762), ('d', 56269), ('c', 50003), ('p', 46335), 
      ('m', 45521), ('v', 24975), ('q', 20889), ('f', 16351), ('b', 13822), ('g', 13288), ('h', 11298), ('j', 8351), 
      ('x', 5928), ('y', 4725), ('z', 2093), ('w', 1747), ('k', 745))
      
    val t = makeOrderedLeafList(frenchFreq)
    val tt = until(singleton, combine)(t)
    assert(convert(until(singleton, combine)(makeOrderedLeafList(frenchFreq)).head) == convert(frenchCode))
  }
  
  test("singleton more than 1"){
    new TestTrees{
      assert(!singleton(List(t0, t0, t0, t0)))
      assert(!singleton(List(t0, t0, t0)))
      assert(!singleton(List(t0, t0)))
    }
    
  }
  
  test("singleton 1"){
    new TestTrees{
      assert(singleton(List(t0)))
      
    }
    
  }
  
  test("singleton 0"){
    new TestTrees{
      assert(!singleton(List()))
    }
    
  }
  

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
  test("decode several") {
    new TestTrees{
      val actual = decode(t2, List(1,0,0,1,0,1,0,0))
      assert( actual == List('d', 'a', 'd', 'b', 'a'))
    }
  }
  
  test("decode d") {
    new TestTrees{
      val actual = decode(t2, List(1))
      assert( actual == List('d'))
    }
  }
  
  test("decode a") {
    new TestTrees{
      val actual = decode(t2, List(0,0))
      assert( actual == List('a'))
    }
  }
  
  test("decode b") {
    new TestTrees{
      val actual = decode(t2, List(0,1))
      assert( actual == List('b'))
    }
  }
  
   test("encode several") {
    new TestTrees{
      val actual = encode(t2)(List('d', 'a', 'd', 'b', 'a'))
      assert( actual == List(1,0,0,1,0,1,0,0))
    }
  }
   
  test("encode d") {
    new TestTrees{
      val actual = encode(t2)(List('d'))
      assert( actual ==  List(1))
    }
  }
  
  test("encode a") {
    new TestTrees{
      val actual = encode(t2)(List('a'))
      assert( actual ==  List(0,0))
    }
  }
  
  test("encode b") {
    new TestTrees{
      val actual = encode(t2)(List('b'))
      assert( actual ==  List(0,1))
    }
  }
  
  

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("convert t2") {
    new TestTrees{
      val actual = convert(t2)
      assert(actual.size == 3)
      assert( actual.exists(x => x._1 == 'a' && x._2 == List(0,0)))
      assert( actual.exists(x => x._1 == 'b' && x._2 == List(0,1)))
      assert( actual.exists(x => x._1 == 'd' && x._2 == List(1)))
    }
  }
  
  test("quickEncode several") {
    new TestTrees{
      val actual = quickEncode(t2)(List('d', 'a', 'd', 'b', 'a'))
      assert( actual == List(1,0,0,1,0,1,0,0))
    }
  }
}
