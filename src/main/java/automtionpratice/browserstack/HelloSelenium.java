package automtionpratice.browserstack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloSelenium {

    public static void main(String[] args) {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--blink-settings=imagesEnabled=false");
//    	options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            HomePage homePage = new HomePage(driver);
            System.out.println("List Featured productss");
            for (HomeProductItem productItem : homePage.getPopularProducts()) {
                System.out.println(productItem);
            }

            System.out.println("List Bestseller productss");
            for (HomeProductItem productItem : homePage.getBestsellerProducts()) {
                System.out.println(productItem);
            }
            
            
        } finally {
            driver.quit();
        }
    }
}
