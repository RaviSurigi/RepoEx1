Feature: Example Feature
Scenario: Verify Google Search
Given I navigate to "https://www.google.com"
When I search for "Cucumber"
Then I should see search results