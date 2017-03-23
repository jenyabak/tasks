package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TelefonyPage extends BasePage  {
	

	public TelefonyPage(WebDriver driver) {
		super(driver);
	}

	
	By smartfony = By.xpath("//*[@id='menu_categories_left']/li[1]/ul/li[1]/a");
	
//	public SmartfonyPage goto_smartfony(WebDriver driver, int i){
//		driver.findElement(smartfony ).click();
//		return new SmartfonyPage(driver, i);
//		
//	}

	public SmartfonyPage goto_smartfony(WebDriver driver){
		driver.findElement(smartfony ).click();
		return new SmartfonyPage(driver);
		
	}
	
}    
