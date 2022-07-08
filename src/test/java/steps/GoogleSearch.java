package steps;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SearchPage;

import java.io.IOException;

public class GoogleSearch extends TestBase {
    SearchPage searchPage;

    public GoogleSearch() throws IOException {
    }

    @Given("user can open google search page")
    public void user_can_open_google_search_page() throws IOException {
        driver.get(prop.getProperty("url"));
        searchPage = new SearchPage();
        searchPage.clickOnButton(searchPage.englishLanguageButton);
    }
    @When("user enters a text in search box and click on Search button")
    public void user_enters_a_text_in_search_box_and_hits_enter() {
        searchPage.performSearch(prop.getProperty("searchText"));
        Assert.assertEquals(driver.getTitle(),"Cars in London - Google Search");
    }
    @Then("user is navigated to search results,gets how many Ad links are available")
    public void user_is_navigated_to_search_results_gets_how_many_ad_links_are_available() {
        Assert.assertNotEquals(searchPage.getNumberOfAds(),0);

    }
    @Then("navigate to them to confirm the title")
    public void navigate_to_them_to_confirm_the_title() throws InterruptedException {
        searchPage.clickOnAllAds();

    }

}
