Feature: Feature to test the login functionality
	
	@SmokeTest
	Scenario: Check login successfully
		Given Browser is open
		And user is on login page
		When user enters username and password
		And clicks on login button