package com.carlosmorenorios.adventofscala2017.days

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Day1 {

  def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val numbers = Util.readInput("/day1.txt")(0)
    println("Result of first part: " + extractMatchingNumbers(numbers, 1).sum)
    println("Result of second part: " + extractMatchingNumbers(numbers, numbers.length / 2).sum)
  }

  def extractMatchingNumbers(numbers: String, steps: Int): List[Int] = {
    (0 until numbers.length)
      .filter(i => numbers(i).equals(numbers((i + steps) % numbers.length)))
      .map(i => numbers(i))
      .map(_.asDigit)
      .toList
  }
}
