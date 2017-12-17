package com.carlosmorenorios.adventofscala2017.days

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Day5 {

  def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val input = Util.readInput("/day5.txt")
    val maze = input.map(s => s.toInt)

    println("Result of first part: " + solution(x => x + 1)(0, maze, 0))
    println("Result of second part: " + solution(x => if (x > 2) -1 else 1)(0, maze, 0))
  }

  def solution(offset: Int => Int): (Int, List[Int], Int) => Int = {
    def recur(index: Int, maze: List[Int], counter: Int): Int = {
      if (index >= maze.length || index < 0) {
        counter
      } else {
        val nextMaze = replaceInList(maze, index, offset(maze(index)))
        recur(nextIndex(index, maze), nextMaze, counter + 1)
      }
    }

    recur
  }

  def nextIndex(current: Int, list: List[Int]): Int = {
    current + list(current)
  }

  private def replaceInList(list: List[Int], index: Int, value: Int) = {
    list.patch(index, Seq(value), 1)
  }
}
