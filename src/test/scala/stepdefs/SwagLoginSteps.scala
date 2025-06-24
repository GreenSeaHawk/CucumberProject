package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import locators.SwagLoginLocators._
import pages.ProductPage.{browserLaunch, clickOn, getText, inputText}
import support.CounterGlobal.counter
import support.DriverManager
import support.GlobalVal.testRunCounter
import utils.ScreenCapture.takeScreenshot


class SwagLoginSteps extends ScalaDsl with EN {
  val scenario: String = s"Scenario_$counter"

  Given("""I am on the login page""") { () =>
    browserLaunch()
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_BrowserLaunched", folder_num = testRunCounter)
  }

  When("""I enter a valid username {string}""") { (username: String) =>
    inputText(usernameLocator, username)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_UsernameInputted", folder_num = testRunCounter)
  }

  And("""I enter a valid password {string}""") { (password: String) =>
    inputText(passwordLocator, password)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_PasswordInputted", folder_num = testRunCounter)
  }

  And("""I click Login button""") { () =>
    clickOn(loginButtonLocator)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_LoginButtonClicked", folder_num = testRunCounter)
  }

  Then("""I should be redirected to the products page""") { () =>
    assert(DriverManager.driver.getCurrentUrl == "https://www.saucedemo.com/inventory.html")
    println("We logged in successfully!")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_NavProductPage", folder_num = testRunCounter)
  }

  When("""I enter a locked out username""") { () =>
    inputText(usernameLocator, "locked_out_user")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_UsernameInputted", folder_num = testRunCounter)
  }

  And("""I enter a locked out password""") { () =>
    inputText(passwordLocator, "secret_sauce")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_PasswordInputted", folder_num = testRunCounter)
  }

  Then("""I should have a locked out error message""") { () =>
    assert(getText(lockedOutErrorMessage) == "Epic sadface: Sorry, this user has been locked out.")
    println("Unsuccessful login!")
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_ErrorMessage", folder_num = testRunCounter)
  }

}