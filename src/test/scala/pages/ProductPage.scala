package pages

import org.openqa.selenium.{By, WebElement}

import scala.collection.mutable.ListBuffer


object ProductPage extends BasePage {

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

