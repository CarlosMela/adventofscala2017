package com.carlosmorenorios.adventofscala2017.days

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
object Util {

  def readInput(inputPath: String): List[String] = {
    try {
      def source = io.Source.fromFile(getClass.getResource(inputPath).getFile)

      (for (line <- source.getLines) yield line).toList
    } catch {
      case _: Exception => List()
    }
  }

}
