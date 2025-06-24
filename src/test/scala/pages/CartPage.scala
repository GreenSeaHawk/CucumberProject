package pages

import org.openqa.selenium.{By, WebElement}


object CartPage extends BasePage {


  def countCartItems(selector: By): Int = {
    val cartItemsList: java.util.List[WebElement] = driver.findElements(selector)
    cartItemsList.size()
  }
}

