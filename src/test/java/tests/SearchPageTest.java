package tests;

import base.TestBase;
import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchPageTest extends TestBase {
    SearchPage searchPage;
    public SearchPageTest() throws IOException {
        super();
    }

    @BeforeTest
    public void runBrowser() throws IOException {
        initializeDriver();
        driver.get(prop.getProperty("url"));
        searchPage = new SearchPage();
        searchPage.clickOnButton(searchPage.englishLanguageButton);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test (priority = 1)
    public void searchValidation(){

        searchPage.performSearch(prop.getProperty("searchText"));
        Assert.assertEquals(driver.getTitle(),"Cars in London - Google Search");
    }

    @Test(priority = 2)
    public void ValidateNumberOfAds() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        if (searchPage.getNumberOfAds()>0){
            searchPage.clickOnAllAds();
        }
        else {
            System.out.println("There is no Ads");
        }


    }


    @AfterTest
    public void CloseDriver()
    {
        driver.close();
    }


}
