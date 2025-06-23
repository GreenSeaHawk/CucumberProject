package locators

import org.openqa.selenium.By

object SwagCartLocators {

  val shoppingCartBadgeLocator: By = By.className("shopping_cart_badge")
  val shoppingCartLocator: By = By.className("shopping_cart_link")
  val backpackAddToCartLocator: By = By.id("add-to-cart-sauce-labs-backpack")
  val backpackRemoveLocator: By = By.id("remove-sauce-labs-backpack")
  val backpackInCartLocator: By = By.id("item_4_title_link")
  val cartItemsLocator: By = By.className("cart_item")

}