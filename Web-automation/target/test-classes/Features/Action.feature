Feature: Feature to deal with some action to different content
	
	Scenario: Check liking content
		
		Given Doing a random actions to contents
		And user is on the loginPage
		When user enters the username & the password
		And clicks on the loginButton
		Then user on homePage
		When user likes a content
	
	Scenario: Check commenting content with text only
		
		Given Doing a random actions to contents
		And user is on the loginPage
		When user enters the username & the password
		And clicks on the loginButton
		Then user on homePage
		When user comments content with text only
	
	Scenario: Check commenting content with an image
		
		Given Doing a random actions to contents
		And user is on the loginPage
		When user enters the username & the password
		And clicks on the loginButton
		Then user on homePage
		When user comments content with an image
	
	Scenario: Check commenting content with a document
		
		Given Doing a random actions to contents
		And user is on the loginPage
		When user enters the username & the password
		And clicks on the loginButton
		Then user on homePage
		When user comments content with a document
	
	Scenario: Check commenting content with a link
		
		Given Doing a random actions to contents
		And user is on the loginPage
		When user enters the username & the password
		And clicks on the loginButton
		Then user on homePage
		When user comments content with a link
		