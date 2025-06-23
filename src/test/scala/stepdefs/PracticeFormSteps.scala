package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.LoginPage.{browserLaunch, clickOn, counter, inputText}
import locators.PracticeFormLocators._
import org.openqa.selenium.By
import utils.ScreenCapture.takeScreenshot
import support.DriverManager


class PracticeFormSteps extends ScalaDsl with EN {
//  var firstNamePrefix: String = ""
  counter += 1
  val scenario: String = s"Scenario_$counter"

  Given("""the user is on the practice form page""") { () =>
    // TODO: Navigate to the practice form page
    browserLaunch()

    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_BrowserLaunched")
  }
  And("""cookies are accepted""") { () =>
    // TODO: Navigate to the practice form page
    clickOn(cookiesAcceptLocator)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_CookiesAccepted")
  }

  When("""the user enters valid first name {string}""") { (firstName: String) =>
    // TODO: Enter first name
//    firstNamePrefix = firstName
    inputText(firstNameLocator, firstName)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_FirstNameInputted")
  }

  And("""the user enters valid last name {string}""") { (lastName: String) =>
    // TODO: Enter last name
    inputText(lastNameLocator, lastName)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_LastNameInputted")
  }

  And("""the user clicks on gender {string} button""") { (gender: String) =>
    // TODO: Click gender button
    val genderLocator: By = gender match {
      case "Male" => genderMaleLocator
      case "Female" => genderFemaleLocator
    }
    clickOn(genderLocator)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_GenderClicked")
  }

  And("""the user clicks on yrs of exp {string} button""") { (yrsOfExp: String) =>
    // TODO: Click years of experience button
    val yearsLocator: By = yrsOfExp match {
      case "1" => experience1Locator
      case "2" => experience2Locator
      case "3" => experience3Locator
      case "4" => experience4Locator
      case "5" => experience5Locator
      case "6" => experience6Locator
      case "7" => experience7Locator
    }
    clickOn(yearsLocator)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_YrsOfExpClicked")
  }

  And("""the user enters valid date {string}""") { (date: String) =>
    // TODO: Enter date
    inputText(dateLocator, date)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_DateInputted")
  }

  And("""the user clicks on profession {string}""") { (professions: String) =>
    // TODO: Click profession checkbox
    val professionList = professions.split(",").map(_.trim)

    professionList.foreach {
      case "Manual" =>
        clickOn(professionManualLocator)
      case "Automation" =>
        clickOn(professionAutomationLocator)
      //      case unknown =>
      //        throw new IllegalArgumentException(s"Unknown profession: $unknown")
    }
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_ProfessionsClicked")
  }

  And("""the user clicks on continent {string} in continents dropdown""") { (continent: String) =>
    // TODO: Select continent from dropdown
    clickOn(continentsLocator)
    val continentLocator: By = continent match {
      case "Asia" => asiaLocator
      case "Europe" => europeLocator
      case "Africa" => africaLocator
      case "Australia" => australiaLocator
      case "South America" => southAmericaLocator
      case "North America" => northAmericaLocator
      case "Antartica" => antarticaLocator
    }
    clickOn(continentLocator)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_ContinentClicked")
  }

  And("""the user clicks on upload image and uploads {string}""") { (file: String) =>
    // TODO: Upload file
    inputText(uploadImageLocator, file)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_ImageUploaded")
  }

  And("""the user clicks on submit button""") { () =>
    // TODO: Click submit button
    clickOn(submitLocator)
    takeScreenshot(DriverManager.driver, prefix = s"${scenario}_SubmitButtonClicked")
  }

  Then("""the practice form should be submitted successfully""") { () =>
    // TODO: Validate form submission success
    println("We submitted the form!")
  }

}