package support

import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import support.CounterGlobal.counter
import support.DriverManager.driver
import utils.ConfigReader
import utils.FileImport.extractNumberFromFile
import utils.ScreenCapture.takeScreenshot


object Hooks extends ScalaDsl with EN {

  val options = new ChromeOptions()
  options.addArguments("--headless=new")

  BeforeAll {
    GlobalVal.testRunCounter = extractNumberFromFile().toString
    CounterGlobal.counter = 1
  }

  Before {
    counter +=1
    println("Launching browser before scenario...")
    DriverManager.driver = new ChromeDriver(options)
    DriverManager.driver.manage().window().maximize()
    val testUrl = ConfigReader.get("base.url")
    driver.get(testUrl)
  }

  After { scenario: Scenario =>
    if (scenario.isFailed) {
      takeScreenshot(DriverManager.driver, prefix = "FailedScenario")
    }
    println("Closing browser after scenario...")
    DriverManager.driver.quit()
  }
}
