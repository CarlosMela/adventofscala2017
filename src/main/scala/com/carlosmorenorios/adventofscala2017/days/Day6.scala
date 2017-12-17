package com.carlosmorenorios.adventofscala2017.days

import com.carlosmorenorios.adventofscala2017.days.Util.replaceInList

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Day6 {

  def main(args: scala.Array[scala.Predef.String]): scala.Unit = {
    val input = Util.readInput("/day6.txt")(0).split('\t').map(_.toInt).toList

    val s1 = solution(input, true)
    println("Result of first part: " + s1._1)
    println("Result of second part: " + solution(s1._2, false)._1)
  }

  def solution(list: List[Int], anyRepetition: Boolean): (Int, List[Int]) = {
    def iterate(iteration: Int, configuration: List[Int], configurations: Set[List[Int]]): (Int, List[Int]) = {
      if (configurations contains configuration) {
        (iteration, configuration)
      } else {
        iterate(iteration + 1, distributeMemory(configuration), configurations + (if (anyRepetition) configuration else list))
      }

    }

    iterate(0, list, Set())
  }

  private def distributeMemory(configuration: List[Int]): List[Int] = {
    var pivot = findPivot(configuration)
    var mem = configuration(pivot)
    var config = replaceInList(configuration, pivot, 0)
    while (mem > 0) {
      pivot = (pivot + 1) % config.length
      config = replaceInList(config, pivot, config(pivot) + 1)
      mem -= 1
    }
    config
  }

  private def findPivot(list: List[Int]): Int = {
    val max = list.max
    Range(0, list.length).find(x => list(x) == max).getOrElse(-1)
  }
}