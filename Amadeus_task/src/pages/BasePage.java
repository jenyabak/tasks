package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import helper.GetPropertyValues;

public class BasePage {
	
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	

	public HomePage GotoHomePage(WebDriver driver) throws IOException {
		String test_site_url = new GetPropertyValues().getPropValues("test_site");
		this.driver = driver;
		driver.get(test_site_url);
		//driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new HomePage(driver);
		
	}


//for debug
	public SmartfonyPage goto_smartfony_page(WebDriver driver) throws IOException, InterruptedException {
		String test_site_url = new GetPropertyValues().getPropValues("test_site");
		this.driver = driver;
		driver.get(test_site_url);
		return new SmartfonyPage(driver);
	}



//	public SmartfonyPage goto_smartfony_page(WebDriver driver, int i) throws IOException {
//		String test_site_url = new GetPropertyValues().getPropValues("test_site");
//		this.driver = driver;
//		driver.get(test_site_url);
//		return new SmartfonyPage(driver, i);
//	}


	
}
