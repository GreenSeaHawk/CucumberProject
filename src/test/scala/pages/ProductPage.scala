package pages

import org.openqa.selenium.{By, WebElement}
import locators.SwagProductsLocators._

import scala.collection.mutable.ListBuffer
//import locators.LoginLocators.{Password, Submit, Username}

object ProductPage extends BasePage {

  // — User Name —

  //  def inputUserName(text: String): Unit =
  //    inputText(Username, text)
  //
  //  // — Password —
  //  def inputPassword(text: String): Unit = {
  //    inputText(Password, text)
  //  }
  //  // — Submit Button —
  //  def buttonSubmit(): Unit = {
  //    clickOn(Submit)
  //  }
  def getListOfPrices(locators: By): ListBuffer[Double] = {
    val listOfPrices = ListBuffer.empty[Double]
    val prices: java.util.List[WebElement] = driver.findElements(locators)
    for (i <- 0 until prices.size()) {
      val price = prices.get(i)
      js.executeScript("arguments[0].scrollIntoView();", price)
      val cleanedPrice = price.getText.replaceAll("[^\\d.]", "")
      listOfPrices += cleanedPrice.toDouble
    }
    listOfPrices
  }

}

