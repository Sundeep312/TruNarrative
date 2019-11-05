Feature: TruNarrative Task 

Scenario: Positive google search validtion  
Given user navigate to "https://www.google.com" site
When user enters "TruNarrative" and click search
Then user shall find "https://trunarrative.com" link on topsearch
And Verify "Easy Onboarding. Smooth Transactions. Insightful Compliance" is found on webpage



Scenario: Validate navigation to team page
Given navigate to "https://trunarrative.com" site again
When user click on  "TruNarrative Team"
Then following "John Lord" and "Founder and CEO" and "David Eastaugh" and "CTO" and "Nicola Janney" and "Human Resources Manager" shall displayed on webpage 



