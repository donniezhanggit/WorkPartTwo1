This is the variant of the test task written on **Java + **Selenide + BDD****
 
 #### Tests to develop:
 1. **Test #1.** 
 -Open Google. 
 -Search for “automation”. 
 -Open the first link on search results page. 
 -Verify that title contains searched word
 2. **Test #2.** 
 -Open Google. 
 -Search for “automation”. 
 -Verify that there is expected domain (“testautomationday.com”) on search results  pages (page: 1-5).
 
 #### **What was used:**
 - **Selenide**
 - **Maven**
 - **Junit**
 - **Page object**
 - **BDD - Cucumber** 
 - **Video-recorder** _(records video in case the test fails)_
 - **Allure reporting**
 
 **To run the tests from command line, you need to go to the project`s directory (command: 'cd') and enter command:** _**mvn clean test**_