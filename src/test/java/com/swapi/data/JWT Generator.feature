Feature: Create JWT Token
 
Scenario: Verify that a new JWT is successfully getting created
 
Given url 'http://localhost:8200/authenticate'
When request { "username":"pavan", "password":"password"}
And method post
Then status 200
And print 'Response is: ', response
