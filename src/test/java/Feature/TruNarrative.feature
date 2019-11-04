Feature: TruNarrative Task 

Scenario: Positive google search validtion  
Given intialise driver with chrome browser
And navigate to "https://www.google.com" site
When user enters "TruNarrative" and click search
Then Verify first search shall be "https://trunarrative.com" and click on first link displayed verify the step1 link navigate to TrunNarrative website
And Verify "Easy Onboarding. Smooth Transactions. Insightful Compliance" is found on webpage
And close all open browsers


Scenario: Validate navigation to team page
Given intialise driver with chrome browser again
And navigate to "https://trunarrative.com" site again
When user do mouseover on more and user shall able to navigate to Trunarrative team page and match with "TruNarrative Team"
Then following "John Lord" and "Founder and CEO" and "David Eastaugh" and "CTO" and "Nicola Janney" and "Human Resources Manager" shall displayed on webpage 
And close agian all browsers 


