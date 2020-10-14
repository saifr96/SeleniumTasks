Feature: Shopping on a website
As a person 
I want to browse items on a website
So that I can purchase the Items I want

Scenario: Browse the items available on the website
	Given correct web address
	When  navigate to the 'Menu' page
	Then  can browse a list of available items
	
Scenario: Add an item to checkout
	Given correct web address
	When  click the checkout button
	Then  taken to the checkout page