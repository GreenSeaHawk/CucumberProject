package utils

import io.qameta.allure.Allure
import org.openqa.selenium.{OutputType, TakesScreenshot, WebDriver}
import org.openqa.selenium.io.FileHandler

import java.io.{ByteArrayInputStream, File}
import java.text.SimpleDateFormat
import java.util.Date
import utils.ConfigReader


object ScreenCapture {

  val basePathConfig: String = ConfigReader.get("base.path")
  def takeScreenshot(
                      driver: WebDriver,
                      basePath: String = basePathConfig,
                      prefix: String = "",
                      folder_num: String = "1"
                    ): Unit = {
    val timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
    val screenshotFile = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
    val folderPath = s"$basePath/test_run_${folder_num}"
    val folder = new File(folderPath)
    if (!folder.exists()){
      folder.mkdirs()
    }
    val fullPath = s"$basePath/test_run_${folder_num}/${prefix}_$timeStamp.png"
    FileHandler.copy(screenshotFile, new File(fullPath))

    // Print to console
    println(s"Screenshot saved to: $fullPath")

    // Attach screenshot to Allure report
    val screenshotBytes = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.BYTES)
    Allure.addAttachment(s"$prefix, Test Run $folder_num, Screenshot", "image/png", new ByteArrayInputStream(screenshotBytes), ".png")
  }

}