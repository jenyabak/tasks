package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TelefonyTvElektronikaPage extends BasePage  {
	

	public TelefonyTvElektronikaPage(WebDriver driver) {
		super(driver);
	}

	
	By telefony = By.xpath("//*[@id='menu_categories_left']/li[1]/h4/a");
	
	public TelefonyPage goto_telefony(WebDriver driver){
		driver.findElement(telefony).click();
		return new TelefonyPage(driver);
		
	}
	
	
}    
