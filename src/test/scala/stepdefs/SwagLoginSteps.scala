package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.ProductPage.{browserLaunch, clickOn, counter, inputText, getText}
import support.DriverManager
import utils.ScreenCapture.takeScreenshot
import locators.SwagLoginLocators._


class SwagLoginSteps extends ScalaDsl with EN {
  //  var firstNamePrefix: String = ""
  counter += 1
  val scenario: String = s"Scenario_$counter"

  Given("""I am on the login page""") { () =>
    browserLaunch()
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_BrowserLaunched")
  }

  When("""I enter a valid username {string}""") { (username: String) =>
    inputText(usernameLocator, username)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_UsernameInputted")
  }

  And("""I enter a valid password {string}""") { (password: String) =>
    inputText(passwordLocator, password)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_PasswordInputted")
  }

  And("""I click Login button""") { () =>
    clickOn(loginButtonLocator)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_LoginButtonClicked")
  }

  Then("""I should be redirected to the products page""") { () =>
    assert(DriverManager.driver.getCurrentUrl == "https://www.saucedemo.com/inventory.html")
    println("We logged in successfully!")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_NavProductPage")
  }

  When("""I enter a locked out username""") { () =>
    inputText(usernameLocator, "locked_out_user")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_UsernameInputted")
  }

  And("""I enter a locked out password""") { () =>
    inputText(passwordLocator, "secret_sauce")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_PasswordInputted")
  }

  Then("""I should have a locked out error message""") { () =>
    assert(getText(lockedOutErrorMessage) == "Epic sadface: Sorry, this user has been locked out.")
    println("Unsuccessful login!")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_ErrorMessage")
  }

}