# Selenium Automation Testing Project: Identify New Bikes
 
## Project Overview
This Selenium automation testing project focuses on automating tasks on ZigWheels.com
The primary objectives include capturing user information, navigating through the portal, verifying the presence of specific elements. 
The project uses various dependencies and libraries to facilitate automation.

## Project Structure
 
### 1. Maven Repository
 
- *Maven Version*: 3.12.1
 
### 2. Dependencies
 
- *Apache POI*
  - Version: 5.2.2
  - Purpose: Used for reading and writing Excel files, facilitating data-driven testing.
 
- *TestNG*
  - Version: 7.7.1
  - Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
 
- *Extent Report*
  - Version: 5.1.1
  - Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
 
- *Selenium*
  - Version: 4.15.0
  - Purpose: Enables interaction with web elements, navigation, and form submission in the browser.
 
- *Loggers*
  - Version: 2.22.1
  - Purpose: Provides logging capabilities for better debugging and traceability.
 
## Automation Test Flow
 
1. *Open ZigWheels.com*
   - Navigate to the ZigWheels.com.
 
2. *Hover on Used Cars and click on Chennai*
   - Hover on Used Cars tab and click on Chennai.
 
4. *Capture the popular models and display in console*
   - Select all the popular models from the popular models side panel and print in console.
   - Scroll down and take screenshot of the page .
   - Navigate back to home page.
   
6. *Hover on New Bikes and click on Upcoming bikes*
   - Hover on the New Bikes tab and click on Upcoming bikes option.
 
5. *Filter all the honda bikes under 4 lacs*
   - Select Honda from the manufacturer dropdown.
   - Verify whether Honda bikes are displayed or not.
   - Filter and print all the bikes under 4 lacs.
   - Capture screenshot of the page.
   - Navigate to home page.
 
6. *Click on Login button*
   - Click on Login button in homepage .
   - Click on Google SignIn button.
 
7. *Provide a invalid login details*
   - Provide an invalid email-id and print the error message in the console .
   - Capture the screenshot.
 
8. *Verify the results displayed *
   - Verify and write the results in excel sheet.
 
## How to Run the Tests
 
1. *Open Eclipse IDE:*
   - Launch Eclipse IDE on your machine.
 
2. *Import Project:*
   - Select File -> Import from the menu.
   - Choose Existing Maven Projects and click Next.
   - Browse to the directory where you cloned the repository and select the project.
 
3. *Update Maven Project:*
   - Right-click on the project in the Project Explorer.
   - Choose Maven -> Update Project.
   - Click OK to update dependencies.
 
4. *Set Up Configuration:*
   - Open the src/test/resources/config.properties file.
   - Update any configuration parameters like browser type, URLs, etc., as needed.
 
5. *Run Test Suite:*
   - Locate the test suite file (e.g., src/test/java/TestSuite.java).
   - Right-click on the file and choose Run As -> TestNG Suite.
 
6. *View Reports:*
   - After execution, open the test-output folder.
   - Find the Extent Report HTML file (index.html) for detailed test reports.
 
## Author Information
 
- *Sayan Dey*
 
## Disclaimer
 
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.