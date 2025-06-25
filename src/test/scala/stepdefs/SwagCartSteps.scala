package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SwagCartLocators._
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import pages.ProductPage._
import pages.CartPage.countCartItems
import support.DriverManager.driver
import support.GlobalVal.testRunCounter
import utils.ScreenCapture.takeScreenshot
import support.CounterGlobal.counter

import java.time.Duration


class SwagCartSteps extends ScalaDsl with EN {
  val scenario: String = s"Scenario_$counter"

  When("""I click Add to cart""") { () =>
//    val actions = new Actions(driver)
//    val element = driver.findElement(backpackAddToCartLocator)
//    println("Element displayed: " + element.isDisplayed)
//    println("Element enabled: " + element.isEnabled)
//    actions.moveToElement(element).click().perform()
//    val explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10))
//
//    val addToCart = explicitWait.until(  ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")))
//    Thread.sleep(2000)
//    addToCart.click()
    clickOn(backpackAddToCartLocator)
//    Thread.sleep(2000)

    takeScreenshot(driver, prefix = s"${scenario}_AddToCart", folder_num = testRunCounter)
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
    takeScreenshot(driver, prefix = s"${scenario}_NavToCart", folder_num = testRunCounter)
  }


}