package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage  {
	

	public HomePage(WebDriver driver) {
		super(driver);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='3361']/a")));

			
	}

	
	By telefony_tv_i_ehlektronika = By.xpath("//*[@id='3361']/a");
	
	public TelefonyTvElektronikaPage goto_telefony_tv_i_ehlektronika(WebDriver driver){
		driver.findElement(telefony_tv_i_ehlektronika).click();
		return new TelefonyTvElektronikaPage(driver);
	}

	
	
}    
