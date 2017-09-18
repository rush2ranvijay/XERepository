Feature: LogIn and Registration Action Test
Description: This feature will test a LogIn, Registration and LogOut functionality

Scenario: Successful Login with Valid Credentials
     Given User is on Home Page
     When User enters blank userName "ranvijay@sharklasers.com" and password "test1"
     Then User get error messages on Home Page
     When User click on create account link
     Then User navigate on Register Page with title "Registration Page" 
     When User enters "ranvijay@sharklasers.com", "Ranvijay Pratap", "Singh", "test1" as registration fields
     Then Registration is successfull and user navigated to Home Page
     When User enters "ranvijay@sharklasers.com" and "test1"
     Then User Navigate to main Page
     And User LogOut from the Application
     Then User is again on Home Page