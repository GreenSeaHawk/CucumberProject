package locators

import org.openqa.selenium.By

object PracticeFormLocators {

  //  // Login Page
  //  val Username: By = By.name("username")
  //  val Password: By = By.name("password")
  //  val Submit:   By = By.cssSelector("input[type='submit']")

  // Practice Form Page
  val firstNameLocator: By = By.name("firstname")
  val lastNameLocator: By = By.name("lastname")
  val genderMaleLocator: By = By.id("sex-0")
  val genderFemaleLocator: By = By.id("sex-1")
  val experience1Locator: By = By.id("exp-0")
  val experience2Locator: By = By.id("exp-1")
  val experience3Locator: By = By.id("exp-2")
  val experience4Locator: By = By.id("exp-3")
  val experience5Locator: By = By.id("exp-4")
  val experience6Locator: By = By.id("exp-5")
  val experience7Locator: By = By.id("exp-6")
  val dateLocator: By = By.id("datepicker")
  val professionManualLocator: By = By.id("profession-0")
  val professionAutomationLocator: By = By.id("profession-1")
  //  val autoToolsUFTLocator: By = By.id("tool-0")
  //  val autoToolsProtractorLocator: By = By.id("tool-1")
  //  val autoToolsSeleniumLocator: By = By.id("tool-2")
  val continentsLocator: By = By.id("continents")
  val asiaLocator: By = By.cssSelector("#continents > option:nth-child(1)")
  val europeLocator: By = By.cssSelector("#continents > option:nth-child(2)")
  val africaLocator: By = By.cssSelector("#continents > option:nth-child(3)")
  val australiaLocator: By = By.cssSelector("#continents > option:nth-child(4)")
  val southAmericaLocator: By = By.cssSelector("#continents > option:nth-child(5)")
  val northAmericaLocator: By = By.cssSelector("#continents > option:nth-child(6)")
  val antarticaLocator: By = By.cssSelector("#continents > option:nth-child(7)")
  val uploadImageLocator: By = By.id("photo")
  val submitLocator: By = By.id("submit")

  val cookiesAcceptLocator: By = By.id("ez-accept-necessary")

}
