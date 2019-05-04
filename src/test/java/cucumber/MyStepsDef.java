package cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepsDef extends BaseTest {

    @Given("^Open \"([^\"]*)\" page$")
    public void open_page(String url) {
        open(url);
    }

    @When("^Search for \"([^\"]*)\"$")
    public void search_for(String searchedWord) {
        mainPage.searchNecessaryWord(searchedWord);
    }

    @When("^Open the first link on search results page$")
    public void open_the_first_link_on_search_results_page() {
        searchResultPage.openFirstLink();
    }

    @Then("^The title should contains searched word$")
    public void the_title_should_contains_searched_word()  {
        webSitePage.verifyTitleContainsWord("automation");
    }

    @When("^Serch for \"([^\"]*)\"$")
    public void serch_for(String searchedWord) {
        searchResultPage.searchNecessaryWord(searchedWord);
    }

    @Then("^Expected domain should be present on search results pages\\.$")
    public void expected_domain_should_be_present_on_search_results_pages() {
        searchResultPage.verifyDomainOnSearchResultPage(domain, 5);}
}
