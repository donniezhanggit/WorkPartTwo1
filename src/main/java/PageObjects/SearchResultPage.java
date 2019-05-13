package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage extends MainPage {

    @FindBy(css = "#pnnext")
    private SelenideElement nextButtonSelector;

    @FindBy(css = ".iUh30")
    private ElementsCollection pageLinks;

    private String linkSelector = ".iUh30";

    public WebSitePage openFirstLink() {
        pageLinks.get(0).click();
        return page(WebSitePage.class);
    }

    public SearchResultPage pressNextPageButton() {
        nextButtonSelector.click();
        return this;
    }

    public boolean verifyDomainOnSearchResultPage(String expectedDomain, int numberOfSearchResultPages) {
        boolean searchResult = false;
        for (int i = 0; i < numberOfSearchResultPages; i++) {
            if (fIndDomain()) {
                searchResult = true;
                break;
            }
            pressNextPageButton();
        }
        if (searchResult){
            Allure.addAttachment("Verifying expected domain on SearchResultPage", "Success. " + expectedDomain + " is present on result page");
        }else {
            Allure.addAttachment("Verifying expected domain on SearchResultPage", "Oops. There is no " + expectedDomain + " on result pages");
        }
        return searchResult;
    }

    private boolean fIndDomain() {
        String domain = "https://www.testautomationday.com/";
        for (WebElement link : $$(By.cssSelector(linkSelector))) {
            if (link.getText().contains(domain)) {
                Allure.addAttachment("Search for domain", "Domain " + domain + " exist");
                return true;
            }
        }
        return false;
    }
}