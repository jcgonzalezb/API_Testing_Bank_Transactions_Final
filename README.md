# Bank transactions API testing program
> This project is a program which allows users to test an endpoint for Bank transactions.

## Objectives

- Create an account https://www.mockapi.io/projects and set up an endpoint for Bank transactions (all
information embedded in same API, i.e., only 1 endpoint required).

- Structure the project making the requests reusable, avoid to repeat code or the endpoints, use TestNG
and create a Readme.md with the specifications and steps to run the exercise and add a gitignore.

- For every request please make sure to include at least an assertion for the Status Code (Use POJOs to
manage response data not just the body). Please make sure you use JavaDoc.

- Create the following tests using the the Bank transactions endpoint:

  - @Test 1 > Verify the Endpoint is empty (If it has any data use the DELETE request to clean and
  leave it empty)
  - @Test 2 > Initialize the POJO with 10 random data (Use the minimal Requirements). Also, make
  a code verification for avoiding duplicate email accounts. Then, perform the POST request.
  - @Test 3 > Make the GET request, asserting that there are not duplicate email accounts.
  - @Test 4 > Add a test to update an existing AccountNumber

## Table of content

* [Environment](#environment)
    * [File Descriptions](#file-descriptions)
    * [API Endpoint](#api-endpoint)
* [Installation](#installation)
* [Usage](#usage)
* [Bugs](#bugs)
* [Author](#author)
* [License](#license)

##  Environment
This project was developed on IntelliJ IDEA 2022.2.3 (Community Edition) and JDK 11.

### File Descriptions
- ```pom.xml``` contains information about the project and configuration details used by Maven to build the project.
- ```src/``` contains all the classes used for this project.
- ```src/main/java/org/Globant/reporting``` contains the Reporter.java file.
- ```Reporter.java``` contains the class Reporter which is used to show messages to the user.
- ```src/test/java/org/Globant/tests``` contains all the test classes used in this project.
- ```BaseTest.java``` contains the class base test used which is used for all the tests implemented in this project.
- ```CreateTransactionsTest.java``` contains the class CreateTransactionsTest which represents the POJO initialization with random data and duplicate email check test.
- ```EndpointEmptyTest.java``` contains the class EndpointEmptyTest which represents the empty endpoint verification test.
- ```ObtainTransactionsTest.java``` contains the class ObtainTransactionsTest which represents to obtain all bank transaction from endpoint and duplicate email check test.
- ```ObtainTransactionsTest.java``` contains the class UpdateTransactionTest which represents the update an existing account number test.
- ```src/test/java/org/Globant/utils``` contains the Listener.java file.
- ```Listener.java``` contains the class Listener which is used to show messages to the user based on test success or failure.
- ```src/test/java/org/Globant/endpoints``` contains the BankTransaction.java file.
- ```BankTransaction.java``` contains the class BankTransaction which represents a bank transaction.
- ```src/test/resources``` contains several files needed for the correct execution of the program. 
- ```log4j.properties``` contains the configuration for the log4j dependency.
- ```suite.xml``` contains a set of configurations that tell testNg how to run our test cases.

### API Endpoint

This is the available endpoint for this project.

https://mockapi.io/projects/637d966d9c2635df8f89fa86

## Installation

1. Clone this repository

```
Open IntelliJ -> Select Git -> Select Clone... -> Select URL and enter "https://github.com/jcgonzalezb/API_Testing_Bank_Transactions_Final" -> Click on Clone.
```

After this, the program is ready to run.

## Usage

1. Once the program is installed, find the suite.xml file, make right-click on this file and select "Run suite.xml".
2. The tests inside the suite.xml will run and the results of the tests will be shown. 

Here is an example of the test results.
```
Getting all transactions from the endpoint...
Amount of transactions on the endpoint: 10 transactions.
Deleting all transactions from the endpoint...
Amount of transactions on the endpoint: 0 transactions.
The endpoint is empty.
Test: verifyEndpointIsEmpty [PASSED]
Initializing the POJO and creating ten transactions using random data.
Checking new transactions, looking for duplicate emails.
Sending the ten transactions to the endpoint...
All ten transactions were created on the endpoint.
Test: createRandomTransactionsTest [PASSED]
Getting all transactions from the endpoint...
Amount of transactions on the endpoint: 10 transactions.
Checking all transactions from the endpoint looking for duplicate emails
All transactions have different emails. No duplicated emails were found.
Test: getTransactionsTest [PASSED]
Getting all transactions from the endpoint...
Amount of transactions on the endpoint: 10 transactions.
The transaction with Account Number 848225 will be updated.
The Account Number 848225 was replaced by the new account number 149474.
A transaction was updated using an existing account number.
Test: updateAccountNumberTest [PASSED]

===============================================
API Testing Final Test suite
Total tests run: 4, Passes: 4, Failures: 0, Skips: 0
===============================================


Process finished with exit code 0
```

## Bugs

Only integers must be entered when options are show during the execution of the program. Otherwise, the program will finish immediately.


## Author

- Juan Camilo González <a href="https://twitter.com/juankter" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="juankter" height="30" width="40" /></a>
  <a href="https://bit.ly/2MBNR0t" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="https://bit.ly/2mbnr0t" height="30" width="40" /></a>

## License

Public Domain. No copy write protection.