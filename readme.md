# SauceDemo Screenplay Serenity BDD

This repository contains an automated testing project using the Screenplay Pattern with Serenity BDD for the SauceDemo application. The goal of this project is to create readable and scalable tests, leveraging Serenity BDD’s ability to generate detailed and structured reports.

## Description

This project performs automated tests on SauceDemo, a sample e-commerce application, validating various functionalities such as login, navigation, and product display. The implementation follows the Screenplay Pattern, which facilitates creating highly maintainable and understandable tests.

## Technologies Used

* Java: Main programming language.
* Serenity BDD: Automation framework that provides advanced reporting.
* Screenplay Pattern: Design pattern to create flexible, modular, and easy-to-read tests.
* Cucumber: BDD framework that enables writing test cases in natural language.
* JUnit: Java testing framework used alongside Serenity.

## Project Structure

The project is organized into several packages to improve organization and separation of responsibilities:

* tasks: Contains tasks performed by actors, such as entering credentials and navigating the app.
* interactions: Defines detailed interactions with the app, such as clicks and waits.
* questions: Asks questions about the app's state to validate conditions.
* ui: Contains user interface elements, making it easy to locate items within the app.
* stepdefinitions: Defines Cucumber steps that correspond to test scenarios written in Gherkin

## Installation

1. Clone this repository:
   ```
    git clone https://github.com/FrankAtencioLoreth/SauceDemoScreenplaySerenityBDD.git

2. Import the project into your favorite IDE (IntelliJ or Eclipse recommended).
3. Ensure you have Java 11 or later installed on your system.
4. Run `gradlew clean test` to compile the project and execute the tests.

## Running Tests
To execute the tests, you can use the following command: <br>
    ```
    gradlew clean test
    ```

This command will compile the project and run all tests. Once the execution is complete, you can view the detailed report at target/site/serenity/index.html.

To execute the tests by tagname, you can use the following command: <br>
    ```
    gradlew clean test -Dcucumber.filter.tags="@tagname"
    ```

## Reports
Serenity BDD generates a detailed HTML report after each test run. The reports include:

* Status of each test (passed, failed, pending).
* Screenshots at key points of each test.
* Execution time for each step.
* To view the report, open the file:
    ```
    target/site/serenity/index.html

## Test Scenarios
The project includes test scenarios to verify:

* Login with valid and invalid credentials.
* Navigation to the main dashboard and validation of visible elements.
* Display of available products.