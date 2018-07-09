eSped-UI-Automation
This framework was built for applications under eSped application suite. It can be used for any version of the applications.

Getting Started
Project repository name: eSped-UI-Automation, can be found on https://github.com/FrontlineEducation/eSped-UI-Automation
Clone/download the repository to the directory in the following path C:\ located on your machine. Name the folder eSped-UI-Automation

Prerequisites
Eclipse/ IntelliJ
Java JDK
Git Client (i.e GitKraken)

- After cloning/downloading the repository, open the project using your preferred IDE.
- If you're using Eclipse right click on the project, select Maven and click "Update Project". this will install all the test dependencies to the librabry.
  additional test dependencies can be added in the "pom.xml" file. use the same file to control the version of the installed test dependencies.
- To run the tests, right click on the "TestSuite.xml" file and click Run As/Debug As TestNG Suite. 
  Tests need to be run using xml files since the BaseTest has parameter value dependencies that are declared in the xml file.


Built With
Selenium - WebDriver 
TestNG - testing framework 
Apache POI - Java libraries for reading and writing files in Microsoft Office formats
Maven - Dependency Management

Author
Imran Sahil

