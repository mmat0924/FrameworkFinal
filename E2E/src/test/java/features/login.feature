Feature: Application Login


Scenario Outline: Login to the application with valid username and password

Given Initialize the browser
And Navigate to "https://courses.rahulshettyacademy.com/" specified
And click on login button
When User enters username <username> password <password> and clicks logIn button
Then Verify Login is successful 
And logout of the application 

Examples:

|username		 	|password	|
|test99@gmail.com	|123456		|
|test100@gmail.com	|123456		|


