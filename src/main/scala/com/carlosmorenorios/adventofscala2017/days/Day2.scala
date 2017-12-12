package com.carlosmorenorios.adventofscala2017.days

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Day2 {

  def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val input = Util.readInput("/day2.txt")
    println("Result of first part: " + input.map(findDiffMaxMin).sum)
    println("Result of second part: " + input.map(findEvenlyQuotientOrZero).sum)
  }

  def findDiffMaxMin(numbers: String): Int = {
    val ints = numbers.split('\t').map(n => n.toInt)
    ints.max - ints.min
  }

  def findEvenlyQuotientOrZero(numbers: String): Int = {
    val ints = numbers.split('\t').map(n => n.toInt)
    ints
      .map(n => getFirstEvenDividend(n, ints).map(_ / n).getOrElse(0))
      .find(_ > 0)
      .getOrElse(0)
  }

  def getFirstEvenDividend(n: Int, numbers: Array[Int]): Option[Int] = {
    numbers.filter(e => e != n).find(_ % n == 0)
  }
}
