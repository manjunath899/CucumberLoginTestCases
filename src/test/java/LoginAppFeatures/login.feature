Feature: Login Functionality

@login   
Scenario Outline: Email and Password Validation in Login API 
   Given Provide different combinations to "<email>""<password>"
   When Post Login API
   Then Status_code equals <statuscode>    
   And  response contains message equals "<message>"
   
   Examples:
   
   |email     		  |password    | statuscode |  message
   |          		  |            |   400      | Required email and password
   | hello@xxx.com  |            |   400      | Email format is incorrect
   | hello@mail7.io |	           |   400      | Required password
   | hello@mail7.io | password   |   400      | Email and Password combination Incorrect
   | hello@gmail.com| password   |   200      | Authentication Successful 