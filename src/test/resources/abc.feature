@regressionTest
@smokeTest 
@jenkinsTest
Feature: Verify login feature in Orange HRM website 

Scenario: dip able to successfully login to Orange HRM site 
	Given dip go to Orange Hrm home page 
	When dip enter valid dipname and password 
	And dip click on the log in button 
	Then dip navigate to the welcome page 
	And dip verify the page title as "OrangeHRM" 
	And dip verify dip name is displays at top right
	Then dip log out
	And dip close browser  
