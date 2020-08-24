Feature: Goibibo Application for booking flight on cheapest price

Scenario Outline: Launch Application and Search flights

Given User launched Application and selected From and Destination "<TestData>"
When User select Departure Date and Traveler Details "<TestData>"
Then User should be able to view the flights avalible 

Examples:
|TestData|
|1|



