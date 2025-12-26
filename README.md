# Selenium cucumber automation framework

## Intro
_____________________

This is a POC that showcases how Cucumber, Selenium, Junit and Extent reports work together.

## Stack
_____________________
1. Java
2. Selenium
3. Cucumber
4. JUnit
5. Extent Reports
6. Grasshopper adapter

## Running the project

### From IDE

Simplest way is just go to a feature and on the left click on the play button and it just works

### Running from commandline
1. Navigate to the project folder with terminal or powershell
2. Use command "./gradlew clean test" to run all tests
3. Use command "./gradlew clean smoke" to run tests tagged with @Smoke
4. Use command "./gradlew clean regression" to run tests tagged with @Regression
5. Tasks can be written for any tag see gradle.build file for instructions

After each run a HTML report and a XML report is generate in the project file
under the "reports" folder. Open with any browser to see it.

### Recommended plugins for intellij

1. Gherkin -> adds support for cucumber
2. Test Automation -> offers support for selenium and an integrated web inspector
3. SonarQube for IDE -> linter for detecting dangerous code or potential bugs
4. Cucumber for java -> makes easier to connect steps to glue code

Enjoy!

Andrei Soare