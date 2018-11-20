package cucumber.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.pages.MainPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;

import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class GoogleSearchTest extends MainPage {
    @Given("^open Google Search Page$")
    public void openGoogleSearchPage() {
        log.info("Navigation to main page");
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        open("https://google.com/");
    }

    @When("^user search for \"([^\"]*)\"$")
    public void userSearchFor(String arg0) {
        log.info("Searching for entered word and click on search button");
        googleSearchField.append(arg0).sendKeys(Keys.ENTER);

    }

    @And("^open first link from search results$")
    public void openFirstLinkFromSearchResults() {
        log.info("Click on First link into list");
        googleSearchTitles.first().click();
    }

    @Then("^title on page contains \"([^\"]*)\"$")
    public void titleOnPageContains(String arg0) {
        log.info("Title verification");
        firstSiteTitle.shouldHave(Condition.matchText(arg0));
    }

    @Then("^domain \"([^\"]*)\" is present on first \"([^\"]*)\" search results pages$")
    public void domainIsPresentOnFirstSearchResultsPages(String siteName, Integer pageAmount) {
        log.info("Domain verification");
        IntStream.range(0, pageAmount)
                .forEach(index -> {
                    Integer value = googleDetectedLinks.filterBy(text(siteName)).size();
                    System.out.println("On " + (1 + index) + " page " + value + "  link found");
                    googleSwitchPages.get(index).click();
                });
    }
}

