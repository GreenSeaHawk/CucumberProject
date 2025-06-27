package support

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import support.CounterGlobal.counter
import support.DriverManager.driver
import support.GlobalVal.testRunCounter
import utils.ConfigReader
import utils.FileImport.extractNumberFromFile
import utils.ScreenCapture.takeScreenshot

import java.time.Duration


object Hooks extends ScalaDsl with EN {

  val options = new ChromeOptions()
  options.addArguments("--headless=new")
  options.addArguments("--guest")
//  options.addArguments("--disable-save-password-bubble")
//  options.addArguments("--disable-popup-blocking")

  BeforeAll {
    GlobalVal.testRunCounter = extractNumberFromFile().toString
    CounterGlobal.counter = 1
  }

  Before {
    counter +=1
    println("Launching browser before scenario...")
    DriverManager.driver = new ChromeDriver(options)
//    DriverManager.driver = new ChromeDriver()
    DriverManager.driver.manage().window().maximize()
    DriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1))
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
  }

  After { scenario: Scenario =>
    if (scenario.isFailed) {
      takeScreenshot(DriverManager.driver, prefix = "FailedScenario", folder_num = testRunCounter)
    }
    println("Closing browser after scenario...")
    DriverManager.driver.quit()
  }
}
