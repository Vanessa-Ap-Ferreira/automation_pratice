package automtionpratice.browserstack;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends LoadableComponent<HomePage> {

	WebDriver driver;
	
	@FindBy(css = "#blockbestsellers > li > div")
	private List<WebElement> bestSellerElements;
	
	@FindBy(css = "#homefeatured > li > div")
	private List<WebElement> productElements;
	
	public HomePage(WebDriver _driver) {
		this.driver = _driver;
		this.get();
		PageFactory.initElements(driver, this);
	}
	
	public List<HomeProductItem> getPopularProducts() {
		Predicate<WebElement> byVisible = product -> product.isDisplayed();

		return productElements
				.stream()
				.filter(byVisible)
				.map(d -> {
					return new HomeProductItem(d);
				})
				.collect(Collectors.toList());
	}

	public List<HomeProductItem> getBestsellerProducts() {
		Predicate<WebElement> byVisible = product -> product.isDisplayed();

		return bestSellerElements
				.stream()
				.filter(byVisible)
				.map(d -> {
					return new HomeProductItem(d);
				})
				.collect(Collectors.toList());
	}
	
	@Override
	protected void load() {
        Wait<WebDriver> wait = new WebDriverWait( driver, 3 );
        wait.until( visibilityOfElementLocated( By.id("div[class='product-container']") ) );
        
	}

	@Override
	protected void isLoaded() throws Error {
        driver.get("http://automationpractice.com/index.php");
		// TODO Auto-generated method stub
		
	}
	
	public ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement toReturn = driver.findElement(locator);
				if (toReturn.isDisplayed()) {
					return toReturn;
				}
				return null;
			}
	  };
	}
	
}
