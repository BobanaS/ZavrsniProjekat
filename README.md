##Project Description

##Title: 
Automated Testing of Web Application using Selenium WebDriver and TestNG

##Brief Description: 
This project involves automating tests for the web application https://www.saucedemo.com/ using Selenium WebDriver and TestNG. Various functionalities of the application were tested, including user login, adding products to cart, and completing the checkout process. Here is also an Excel file with 140 test cases written for for the web application.

##Technologies and Tools
Selenium WebDriver: Used for interacting with web elements and executing tests.
TestNG: Utilized for organizing tests, managing test data, and assertions.
IntelliJ IDEA: Used as the integrated development environment (IDE) for writing and executing tests.
Excel File: Created with 140 test cases for manual testing, serving as a reference for automation.

##Directory Structure
Directory Structure
The project follows the Page Object Model (POM) pattern and is organized into three main packages: Base, Pages, and Tests. 
The structure is as follows:
Base
├── BaseTest.java

Pages

├── CartPage.java

├── CheckOutCompletePage.java

├── CheckOutStepTwoPage.java

├── CheckoutPage.java

├── HomePage.java

├── LogInPage.java

├── ProductPage.java


├── SidebarPage.java

├── SocialNetworkPage.java


Tests

├── CartTests.java

├── CheckOutStepTwoTest.java

├── CheckOutTest.java

├── ChekOutCompleteTest.java

├── HomePageTest.java

├── LogInPageTests.java

├── ProductPageTest.java

├── SideBarTests.java

├── SocialNetworkTests.java

##Running the Tests

To run the tests in IntelliJ IDEA:
Clone or download the project from GitHub.
Open the project in IntelliJ IDEA.
In IntelliJ IDEA, navigate to the src/test/java directory.
Find the test class you want to run (e.g., CartTests.java).
Right-click on the test class -> Run 'CartTests'.

##Key Components Description

BaseTest: Base class containing @BeforeClass and @AfterClass methods used for initializing and closing the test environment.
Pages: Package containing Java classes for each page of the web application (e.g., HomePage.java, LogInPage.java), which include methods for interacting with page elements.
Tests: Package containing TestNG test classes for testing application functionalities (e.g., CartTests.java, CheckOutStepTwoTest.java), covering test steps and assertions.

##Contact Information

LinkedIn: Bobana Simikic / www.linkedin.com/in/bobana-simikic160719918

Email: bobana.simikic@gmail.com
