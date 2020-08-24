Feature: Gillette Application Registration and Login

@Registration
Scenario Outline: Registration Senario

Given User launched the Application for Registration
When User enters "<userInfo>"
And Clicks on Create Accout
Then User is sucessfully registered

Examples:
|userInfo|
|1|
|2|


@Login
Scenario Outline: Login Senario

Given User Launched Signup Page
When User enters Email and Password "<userInfo>"
Then User should be sucessfully navigated to Home Page
Examples:
|userInfo|
|1|

@ResetPassword
Scenario Outline: Forgot and Reset Password Senario

Given User Launched Signup Page for Resetting APassword
When User clicks on reset password "<userInfo>"
Then User should be sucessfully reset the password
Examples:
|userInfo|
|1|
