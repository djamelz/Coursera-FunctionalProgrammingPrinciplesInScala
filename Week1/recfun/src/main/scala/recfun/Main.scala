package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = (c,r) match {
    case (0,_) => 1
    case (c, r) if (c == r) => 1
    case (c, r) => pascal(c,r-1) + pascal(c-1,r-1)
  }
      
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def compute(chars: List[Char], opened: Int): Boolean = (chars, chars.isEmpty, opened) match {
      case (_, _, -1) => false
      case (_, true, 0) => true
      case (_, true, _) => false
      case (chars, _, _) if(chars.head == '(') => compute(chars.tail, opened +1)
      case (chars, _, _)  if(chars.head == ')') => compute(chars.tail, opened -1)
      case (chars, _, _)  => compute(chars.tail, opened)
    }
    compute(chars, 0)
  }
    
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def compute(money: Int, indexCoins: Int): Int = (money, indexCoins) match {
      case(0, _) => 1
      case(money, indexCoins) if(money < 0 || indexCoins < 0) => 0
      case(money, indexCoins) => compute(money, indexCoins - 1) + compute(money - coins(indexCoins), indexCoins)
    }
    compute(money,coins.length - 1)
  }
}