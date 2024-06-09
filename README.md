# Project Title

Description of project -:
1) In this we had followed the page object model approach using programming language as Java and for dependency management we are using maven project .
2) in this project we had 4 packages name as -:
   A) Base - : Tn this we had initilise the driver ,Read the property files and quit the driver 
   b) pageObjects -: in this package we had created a different classes for different pages ( in which we are followed the singeletion pattern approach )
   c) TestSuite -: IN this package we are to write our tests cases .
   d) Utiles -: these are the helper packages where ExtentReport ,Constant and ActionHelper Classes is there .
3) ActionHelper - Basically in this class we had define all the helper methods like ,Click ,sendkeys waits .
4) Testng.xml -: In this we had to define listeners and our class which we want to run 
5) config.properties -: This is the property file we had created for reading the data form property file 
## Getting Started

These instructions will help you get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install and how to install them:

- Java Development Kit (JDK) -17
- Maven

### Installing

A step-by-step series of examples that tell you how to get a development environment running:

1. Clone the repository:

    ```
    git clone https://github.com/rajatgptalko/LeanTech.git
    ```

2. Navigate into the project directory:

    ```
    cd your_project
    ```

3. Build  and run the project using Maven:

    ```
    mvn clean install
    ```

## Running the Tests

1) Basically you need to open testng.xml file .
2) Add your class name in this testng.xml file and then run this file ( on terminal got to your project directory run -:mvn clean install)
3) After successfully run you got the extent.html report in the root folder .
