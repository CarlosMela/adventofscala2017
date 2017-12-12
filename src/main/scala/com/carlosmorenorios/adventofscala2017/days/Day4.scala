package com.carlosmorenorios.adventofscala2017.days

/**
  * @author Carlos Moreno
  * @since 12/12/2017
  */
object Day4 {

  def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val input = Util.readInput("/day4.txt")
    println("Result of first part: " + input.count(noSameWordRepeted))
    println("Result of second part: " + input.count(noSameAnagramRepeted))
  }

  def noSameWordRepeted(s: String): Boolean = {
    val words = s.split(" ")
    words.toSet.size == words.length
  }

  def noSameAnagramRepeted(s: String): Boolean = {
    val words = s.split(" ")
    val letters = words.map(s => s.split("").toSet)
    letters.toSet.size == letters.length
  }
}
