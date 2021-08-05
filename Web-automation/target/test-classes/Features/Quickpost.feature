Feature: Feature to deal with a quickpost 
	
	@SmokeTest
	Scenario: Check adding a quickpost successfully with text only
		
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
		And submitting the quickpost
  
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
	
		
	Scenario: Check adding a quickpost successfully with an external link

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
		And adding a new external link
		Then submitting the quickpost
	
	
	Scenario: Editing a quickpost with text only

		Given Editing a quickpost
		And user is on a login page
		When user enters both username and password
		And clicks on a login button
		Then user on a home page
		And user clicks on editing a quickpost with text only
		
	
	Scenario: Editing a quickpost with an image

		Given Editing a quickpost
		And user is on a login page
		When user enters both username and password
		And clicks on a login button
		Then user on a home page
		And user clicks on editing a quickpost with an image
	
	
	Scenario: Editing a quickpost with a folder

		Given Editing a quickpost
		And user is on a login page
		When user enters both username and password
		And clicks on a login button
		Then user on a home page
		And user clicks on editing a quickpost with an folder
	
	
	Scenario: Deleting a quickpost

		Given Deleting a quickpost
		And user is on a loginpage
		When user enters both username & password
		And clicks on a loginbutton
		Then user on a homepage
		When user clicks on deleting a quickpost
		Then Showing reports path
		
		
