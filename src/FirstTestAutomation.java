import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FirstTestAutomation {


	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
				
		//invoking browser and hitting URL link
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		// Logging-In
		
		driver.findElement(By.id("nav-link-accountList")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		FluentWait<WebDriver> wait = new FluentWait<>(driver);
		wait.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5))
		.ignoring(NoSuchElementException.class);
		driver.findElement(By.className("a-input-text")).sendKeys("number");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("password");
		driver.findElement(By.id("signInSubmit")).click();
		String Name = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		System.out.println(Name + " " + " Loged-in Succesfully");
		
		// Getting All the Offer options from offer menu
		
		String OfferOptions = driver.findElement(By.id("nav-main")).getText();
		System.out.println(OfferOptions);
		System.out.println("This is Offer Options available");
		
		// Getting all the links present on home page
		
		// adding product to the cart
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Minimalist Face Serum");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		// filter's to the product"
			driver.findElement(By.xpath("//span[text()='Get It in 2 Days']")).click();
			System.out.println("As per your selection, Your Order delivery in 2 days");
			driver.findElement(By.xpath("//span[text()='Minimalist']")).click();
			System.out.println("Your Successfully selected Minimalist brand");
			driver.findElement(By.xpath("//span[text()='Eligible for Pay On Delivery']")).click();
			System.out.println("Your Eligible for Pay On Delivery");
			driver.findElement(By.xpath("//span[text()='All Discounts']")).click();
			System.out.println("Applied All Discounts");
			driver.findElement(By.xpath("//span[text()='Minimalist Inc']")).click();
			System.out.println("Your Seller is Minimalist Inc");
			System.out.println("Done");
				
		List<WebElement> Products = driver.findElements(By.xpath("//*[contains(@class, 'puis-card-container')]"));
				System.out.println(Products.size()+ " " + "This is total number of products in search results");
				
				for(WebElement ele: Products) {
					String ProductPrice = ele.findElement(By.className("a-price-whole")).getText();
					System.out.println(ProductPrice);	
			}
				// location details
				
				String Location = driver.findElement(By.id("glow-ingress-line2")).getText();
				assert Location.contains("5600"): "7600 is not in the string";
				System.out.println(Location + " " + "This is the location of your account");
			
				// 3 bar Menu Details
				
				driver.findElement(By.id("nav-hamburger-menu")).click();
				String MenuList = driver.findElement(By.cssSelector("ul.hmenu-visible")).getText();
				System.out.println(MenuList);
				System.out.println("This is Options found in BarMenu");
				
				// Sigging out 
				
				if(MenuList.contains("Sign Out"))
				{
					driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
					System.out.println("Your Account has been Signed Out successfully");
				}
	}	
}
