package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class SearchPage extends TestBase {
    public SearchPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"SIvCob\"]/a")
    public WebElement englishLanguageButton;
    @FindBy(name = "q")
    WebElement searchBar;
    @FindBy(name = "btnK")
    WebElement searchButton;
    @FindBy(xpath = "//title[text()='Cars in London - Google Search']")
    WebElement searchedItemPageTitle;
    @FindBy(id = "result-stats")
    public WebElement numberOfResults;

    @FindBy(className = "sVXRqc")
    public List <WebElement> elements ;

    public void clickOnButton(WebElement buttonName){
        buttonName.click();

    }

    public void performSearch(String searchText){
        searchBar.sendKeys(searchText);
        searchButton.click();
    }

    public int getNumberOfResults(WebElement no_Of_Results){
        String x= no_Of_Results.getText().replaceAll("[^0-9]","");
        x = x.substring(0,x.length()-3);
        return Integer.parseInt(x);

    }

    public int getNumberOfAds ()
    {
        return elements.size();
    }

    public void clickOnAllAds () throws InterruptedException {
        String title;

        for (int i=0; i<elements.size();i++)
        {
            elements.get(i).click();
            title = driver.getTitle();
            Assert.assertFalse(title.isEmpty());
           driver.switchTo().defaultContent();
           driver.navigate().back();


        }
    }





}
