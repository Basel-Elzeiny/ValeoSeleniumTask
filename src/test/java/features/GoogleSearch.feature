Feature: feature to test google search functionality

 Scenario: Validate google search is working
   Given user can open google search page
   When user enters a text in search box and click on Search button
   Then user is navigated to search results,gets how many Ad links are available
   And navigate to them to confirm the title

