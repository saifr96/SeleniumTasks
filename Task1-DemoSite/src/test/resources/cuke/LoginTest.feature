Feature: Login into a website
As a person
I want to generate a new user
So that I can login into my account

	Scenario: Create a new user 
		Given the correct web address
		When I navigate to the 'Add a User' page
		Then I can generate a new user using the following	

			|	Username	|	Password	|
			|	root		|	root		|
	
		And I can login using the new credentials
			|	Username	|	Password	|
			|	root		|	root		|
