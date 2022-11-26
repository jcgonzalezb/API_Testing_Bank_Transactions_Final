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

      - a. Print all the professors with its data
      - b. Print all the classes and a submenu to select a class in order to print the class data including its    teacher and students
      - c. Create a new student and add it to an existing class
      - d. Create a new class and add an existing teacher, existing students and its relevant data
      - e. List all the classes in which a given student is included (hint: search by id)
      - f. Exit


## Table of content
* [Architecture](#architecture)
    * [UML (Unified Modeling Language)](#uml)
* [Environment](#environment)
    * [File Descriptions](#file-descriptions)
* [Bugs](#bugs)
* [Author](#author)
* [License](#license)

##  Architecture
### UML
![UML (Unified Modeling Language)](org/globant/university/images/UML_Globlant_University.png)

##  Environment
This project was developed on IntelliJ IDEA 2022.2.3 (Community Edition) and JDK 11.

### File Descriptions
- ```src/``` contains all the classes used for this project.
- ```data/``` contains base classes used for this project.
- ```University.java``` contains the class University and the basic information of each University.
- ```Course.java``` contains the class Course and the basic information of each Course.
- ```Student.java``` contains the class Student and the basic information of each Student.
- ```Teacher.java``` contains the class Teacher and the basic information of each Teacher.
- ```FullTimeTeacher.java``` contains the class FullTimeTeacher and the basic information of each Full-Time Teacher.
- ```PartTimeTeacher.java``` contains the class PartTimeTeacher and the basic information of each Part-Time Teacher.
- ```persistance/``` contains class DataInitializer for this project.
- ```DataInitializer.java``` contains the code to load the University, classes and student initial information.
- ```view/``` contains class main used for this project.
- ```Main.java``` contains the code to start execution of the Java program.

## Bugs

Only integers must be entered when options are show during the execution of the program. Otherwise, the program will finish immediately.


## Author

- Juan Camilo González <a href="https://twitter.com/juankter" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="juankter" height="30" width="40" /></a>
  <a href="https://bit.ly/2MBNR0t" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="https://bit.ly/2mbnr0t" height="30" width="40" /></a>

## License

Public Domain. No copy write protection.