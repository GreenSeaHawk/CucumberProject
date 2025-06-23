package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SwagCartLocators._
import pages.ProductPage._
import pages.CartPage.countCartItems
import support.DriverManager
import utils.ScreenCapture.takeScreenshot


class SwagCartSteps extends ScalaDsl with EN {
  var firstNamePrefix: String = ""
  counter += 1
  val scenario: String = s"Scenario_$counter"

  When("""I click Add to cart""") { () =>
    clickOn(backpackAddToCartLocator)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_AddToCart")
  }

  Then("""the cart displays a 1""") { () =>
    assert(getText(shoppingCartBadgeLocator) == "1")
  }

  And("""remove is displayed instead of Add to cart""") { () =>
    assert(elementIsDisplayed(backpackRemoveLocator))
  }

  And("""item added to cart""") { () =>
    clickOn(shoppingCartLocator)
    assert(countCartItems(cartItemsLocator) == 1)
    println(countCartItems(cartItemsLocator) + " item(s) in the cart")
    assert(elementIsDisplayed(backpackInCartLocator))
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_NavToCart")
  }


}