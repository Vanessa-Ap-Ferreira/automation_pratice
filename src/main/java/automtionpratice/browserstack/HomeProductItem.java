package automtionpratice.browserstack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeProductItem {
	
	String Name;
	String Price;
	String OldPrice;
	String DiscountPercent;
	
	public HomeProductItem(WebElement element) {
		this.Name = element.findElement(By.cssSelector("a[class='product-name']")).getText();
		WebElement precosElement = element.findElement(By.cssSelector("div[class='right-block'] > div[itemprop='offers']"));
		this.Price = precosElement.findElement(By.cssSelector("span[itemprop='price']")).getText();
		
		List<WebElement> _OldPrices = precosElement.findElements(By.cssSelector("span[class='old-price product-price']"));
		if (_OldPrices.size() > 0) {
			this.OldPrice = _OldPrices.get(0).getText();
		}
		
		List<WebElement> _Discounts = precosElement.findElements(By.cssSelector("span[class='price-percent-reduction']"));
		if (_Discounts.size() > 0) {
			this.DiscountPercent = _Discounts.get(0).getText();
		}
	}
	
	
	@Override
	public String toString() {
		return "HomeProductItem [Name=" + Name + ", Price=" + Price + ", OldPrice=" + OldPrice + ", DiscountPercent="
				+ DiscountPercent + "]";
	}
	
	
}
