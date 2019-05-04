Feature: Test Task Google Search Mape
    Scenario: Verify title of the first link on Google search result page
        Given Open "https://google.com" page
        And Search for "automation"
        When Open the first link on search results page
        Then The title should contains searched word

    Scenario: Verify that there is expected domain on search results  pages (page: 1-5)
        Given Open "https://google.com" page
        When Search for "automation"
        Then Expected domain should be present on search results pages.