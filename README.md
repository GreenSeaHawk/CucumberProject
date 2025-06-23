# CucumberCurriculum

# Scala Selenium Cucumber BDD Framework

This is a test automation framework built with **Scala**, **Selenium WebDriver**, **Cucumber (Gherkin)**, and **sbt**. 
It supports BDD-style testing for web applications.

# Prerequisites

- Java JDK 11+
- sbt 1.9+
- Google Chrome / Firefox
- Cucumber for Scala
- JUnit
- Selenium

# Clone the repository:
# ```bash
git clone git@github.com:MercatorDigitalAcademy/CucumberCurriculum.git
cd CucumberCurriculum.

### How to run the test

# 1. Run just the runner class
sbt "testOnly *TestRunner"

OR
# 2. Run the runner class using the tags
sbt "testOnly *TestRunner -- -Dcucumber.filter.tags=@smoke"

