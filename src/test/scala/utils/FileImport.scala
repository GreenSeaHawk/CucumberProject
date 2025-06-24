package utils


import java.io.{File, PrintWriter}
import scala.io.Source

object FileImport {

  def extractNumberFromFile(
             pathToFile: String = "/Users/andrew.boyce/Documents/Screenshots/Cucumber/counter.txt"
                           ): Int = {
    val file = new File(pathToFile)

    if (file.exists()) {
      val source = Source.fromFile(pathToFile)
      val num: Int = source.mkString.toInt
      val writer = new PrintWriter(file)
      val newNum: Int = num + 1
      writer.write(newNum.toString)
      writer.close()
      newNum
    } else {
      file.createNewFile()
      val writer = new PrintWriter(file)
      val one: String = "1"
      writer.write(one)
      writer.close()
      one.toInt
    }
  }


}
