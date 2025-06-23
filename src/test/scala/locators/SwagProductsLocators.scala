package locators

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.ui.Select

object SwagProductsLocators {

  val sortDropdownLocator: By = By.className("product_sort_container")
  val priceLocators: By = By.xpath("//*[@id=\"inventory_container\"]/div/div[position() > 0]/div[2]/div[2]/div")



}
