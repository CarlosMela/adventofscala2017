package days

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Day1 extends App with AdventDay {

  override lazy val input: List[String] = readInput("/day1.txt")

  override def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val numbers = input(0)
    println("Result of first part: " + sumDigitsString(extractMatchingNumbers(numbers, 1)))
    println("Result of second part: " + sumDigitsString(extractMatchingNumbers(numbers, numbers.length / 2)))
  }

  def extractMatchingNumbers(numbers: String, steps: Int): String = {

    ((0 until numbers.length) map (i => {
      if (numbers(i).equals(numbers((i + steps) % numbers.length))) numbers(i).toString else ""
    })).foldLeft("") { (a, b) => a + b }
  }


  def sumDigitsString(str: String): Int = str.foldLeft(0) { (a, b) => a + b.asDigit }
}
