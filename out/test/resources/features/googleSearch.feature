Feature: Google Search for "automation"

  Scenario Outline: Verify title in content of first link
    Given open Google Search Page
    When user search for "<searchData>"
    And open first link from search results
    Then title on page contains "<searchData>"

    Examples:
      | searchData |
      | Automation |


  Scenario Outline: Verify expected domain on search result page
    Given open Google Search Page
    When user search for "<searchData>"
    Then domain "<domainName>" is present on first "<pageCountToCheck>" search results pages

    Examples:
      | searchData | domainName                               | pageCountToCheck |
      | Automation | https://en.wikipedia.org/wiki/Automation | 5                |



