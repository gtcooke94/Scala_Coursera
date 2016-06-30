package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println(balance("(())".toList) == true)
    println(balance(":)".toList) == false)
    println(balance("((()()))".toList) == true)
    println(balance("(((((((()".toList) == false)

    println(countChange(4, List(1, 2, 3)) == 4)
    println(countChange(4, List(1, 2)) == 3)
    println(countChange(10, List(1, 2, 5)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int =
      if (c == 0 || r == 0 || c == r) 1
      else (pascal(c-1, r-1) + pascal(c, r-1))

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceHelp(chars: List[Char], numberOpens: Int): Boolean = {
        if (chars.isEmpty) numberOpens == 0
        else if (numberOpens < 0) false
        else {
          val headChar = chars.head
          balanceHelp(chars.tail, {
            if (headChar == '(') numberOpens + 1
            else if (headChar == ')') numberOpens - 1
            else numberOpens
          })
        }
      }
      balanceHelp(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (money > 0 && !coins.isEmpty)
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else 0
  }
}
