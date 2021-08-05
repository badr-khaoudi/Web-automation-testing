Feature: User is checking the content available on the web site
	
	Scenario: User is checking an external link
	
		Given Checking content
		And user is on login page checking feature
		When user enters username and password checking feature
		And clicks on login button checking feature
		Then user on home page checking feature
		And user checks an external link
	
	Scenario: Check adding a quickpost successfully with an image

		Given Browser is open
		And user is on login page
		When user enters username and password
		And clicks on login button
		Then user on home page
		When clicks on add content button
		And clicks on add quickpost button
		Then user on quickpost form
		When selects community content type button
		And selected community content
		And filling text area
		And adding a new picture
		Then submitting the quickpost
	
	Scenario: User is checking an image
		
	  Given Checking content
		And user is on login page checking feature
		When user enters username and password checking feature
		And clicks on login button checking feature
		Then user on home page checking feature
		And user checks an image
		
	Scenario: Check adding a quickpost successfully with a document
	
		Given Browser is open
		And user is on login page
		When user enters username and password
		And clicks on login button
		Then user on home page
		When clicks on add content button
		And clicks on add quickpost button
		Then user on quickpost form
		When selects community content type button
		And selected community content
		And filling text area
		And adding a new document
		Then submitting the quickpost
	
	Scenario: User is checking a document
		
		Given Checking content
		And user is on login page checking feature
		When user enters username and password checking feature
		And clicks on login button checking feature
		Then user on home page checking feature
		And user checks a document 
		
		

	
	