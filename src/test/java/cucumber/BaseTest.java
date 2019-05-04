package cucumber;

import PageObjects.MainPage;
import PageObjects.SearchResultPage;
import PageObjects.WebSitePage;
import org.junit.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.page;

public class BaseTest {

//    public MainPage mainPage = new MainPage();
    public MainPage mainPage = page(MainPage.class);
    public SearchResultPage searchResultPage = page(SearchResultPage.class);
    public WebSitePage webSitePage = page(WebSitePage.class);

    private static FileInputStream fileInputStream;
    private static Properties properties;

    protected static  String url;
    protected static  String domain;
    protected static  String searchedWord;

@BeforeClass
    public static void setProperties() {
        try {
            fileInputStream = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        url = properties.getProperty("url");
        searchedWord = properties.getProperty("searchedWord");
        domain = properties.getProperty("domain");
    }
}
