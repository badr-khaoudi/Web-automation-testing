Feature: Feature to deal with an article
  
	Scenario: Check adding an article
		Given Adding an article
		And user is on the login page
		When user enters the username and the password
		And clicks on the login button
		Then user on the home page
		When clicks on the add content button
		And clicks on the add new content
		When clicks on add article
		And add the article title & subtitle
		When add the community content
		And add article text content
		And add a document to the article
		Then submitting the article form