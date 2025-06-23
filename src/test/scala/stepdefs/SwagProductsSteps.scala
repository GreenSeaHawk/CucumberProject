package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SwagLoginLocators._
import pages.ProductPage._
import support.DriverManager
import utils.ScreenCapture.takeScreenshot
import locators.SwagProductsLocators._


class SwagProductsSteps extends ScalaDsl with EN {
  //  var firstNamePrefix: String = ""
  counter += 1
  val scenario: String = s"Scenario_$counter"

  When("""I enter a valid username""") { () =>
    inputText(usernameLocator, "standard_user")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_UsernameInputted")
  }

  And("""I enter a valid password""") { () =>
    inputText(passwordLocator, "secret_sauce")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_PasswordInputted")
  }

  When("""I select Price low to high""") { ()
    selectFromDropdown(sortDropdownLocator, "Price (low to high)")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_SortedProducts")
  }

  Then("""the products should be sorted from lowest to highest""") { ()
    assert(getListOfPrices(priceLocators).sorted == getListOfPrices(priceLocators))
    println("Yay! They are sorted correctly!")
  }

  When("""I select Price high to low""") { ()
    selectFromDropdown(sortDropdownLocator, "Price (high to low)")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_SortedProducts")
  }

  Then("""the products should be sorted from highest to lowest""") { ()
    assert(getListOfPrices(priceLocators).sorted(Ordering[Double].reverse) == getListOfPrices(priceLocators))
//    println(getListOfPrices(priceLocators))
    println("Yay! They are sorted correctly!")
  }
}