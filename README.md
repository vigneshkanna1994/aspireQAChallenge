# aspireQAChallenge
Author: Vigneshkanna A.

Programming Langauge: Java.

Automation Tool: Selenium WebDriver, TestNG.

Design Pattern: Page Object Model.

Project Type: Maven Project.

Project Structure:

![image](https://user-images.githubusercontent.com/39564240/164712165-e7e11e42-0fe7-4ffc-9dea-dde9394f45d3.png)

# Requirement:
The tests that candidate should handle:
URL: https://aspireapp.odoo.com
Login:
Account: user@aspireapp.com
Password: @sp1r3app

1. Login to web application
2. Navigate to `Inventory` feature
3. From the top-menu bar, select `Products -> Products` item, then create a new
product
4. Update the quantity of new product is more than 10
5. From top-left page, click on `Application` icon
6. Navigate to `Manufacturing` feature, then create a new Manufacturing Order item
for the created Product on step #3
7. Update the status of new Orders to “Done” successfully
8. Validate the new Manufacturing Order is created with corrected information.

# Steps to execute test script:
1.  Please import the project git project in Eclipse
2.  Go to "Test Runner" folder
3.  execute "QA_Development_Challenge_Test_testng.xml" as testNG suite. or open package "aspire.pom.tests" and run class "QA_Development_Challenge_Test" as testNG.
4.  Once execution is completed, Refresh the Project.
5.  Go to test-output and open emailable-report.html
6.  User should be able to see the results of Test steps as shown in below
Note: Chrome, firefox drivers and all configuration files has been added. Not required any further configurations.

![image](https://user-images.githubusercontent.com/39564240/164711554-9f5604e9-4924-4600-a90a-5ee8008b77e8.png)

Thanks!!!
