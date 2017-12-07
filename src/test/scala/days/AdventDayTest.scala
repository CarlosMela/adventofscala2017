package days

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.specs2.mutable.Specification

/**
  * @author Carlos Moreno
  * @since 07/12/2017
  */
@RunWith(classOf[JUnitRunner])
class AdventDayTest extends Specification with AdventDay{

  override val input: List[String] = readInput("/test.txt")

  "All days classes" should {
    "Return the input in a list of string" in {
      input should have length 3
      input(0) mustEqual "primera linea"
      input(2) mustEqual  "tercera linea"
    }
  }
}
