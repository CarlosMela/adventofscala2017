package days

import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
trait AdventDay {

  val input: List[String]


  def readInput(filePath: String): List[String] = {
    try {
      def source = io.Source.fromFile(getClass.getResource(filePath).getFile)

      (for (line <- source.getLines) yield line).toList
    } catch {
      case _: Exception => List()
    }
  }

}
