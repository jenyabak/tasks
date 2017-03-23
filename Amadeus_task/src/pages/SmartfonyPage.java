package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class SmartfonyPage extends BasePage  {
	


	public SmartfonyPage(WebDriver driver) {
		super(driver);

	}

	
	By smartfony_page1 = By.xpath("//*[@id='page1']");
	By smartfony_page2 = By.xpath("//*[@id='page2']");
	By smartfony_page3 = By.xpath("//*[@id='page3']");
	
	public SmartfonyPage goto_smartfony_page1(WebDriver driver) throws InterruptedException{
		driver.findElement(smartfony_page1).click();
		Thread.sleep(5000);
		//driver.wait();
		return this;
	}
	
	public SmartfonyPage goto_smartfony_page2(WebDriver driver) throws InterruptedException{
		driver.findElement(smartfony_page2).click();
		Thread.sleep(5000);
		return this;
	}
	
	public SmartfonyPage goto_smartfony_page3(WebDriver driver) throws InterruptedException{
		driver.findElement(smartfony_page3).click();
		Thread.sleep(5000);
		return this;
	}
	
   public boolean smartfon_is_top(int i){
   try {
	    driver.findElement(By.xpath("//*[@id='catalog_goods_block']/div/div["+i+"]//*[@class='g-tag g-tag-icon-middle-popularity sprite']"));  
	    		return true;
	   
    } catch (NoSuchElementException e) {
    	return false;
 	}}
   
   
   public String get_smartfon_name(int i){
	  String name = driver.findElement(By.xpath("//*[@id='catalog_goods_block']/div/div["+i+"]/div[1]/div/div/div[2]/div[4]/a"))
			  .getText(); 
	return name;
	   
   }
   
   public int get_smartfon_price(int i){
	   
   String price = driver.findElement(By.xpath("//*[@id='catalog_goods_block']/div/div["+i+"]//*[@class='g-price-uah']")).getText();
   price = price.replaceAll(" |\\D", ""); 
   System.out.println(price);
//   String pattern = "/^[0-9]*";
//   Pattern r = Pattern.compile(pattern);
//   Matcher m = r.matcher(price);
//   return Integer.parseInt(m.group(0));

   return Integer.parseInt(price);
	   
   }


//	public SmartfonyPage(WebDriver driver, Integer i) {
//		super(driver);
//
//	}
//	Integer i = 1;
//	public SmartfonyPage goto_smartfony_page(WebDriver driver) throws InterruptedException{
//		By smartfony_page = By.xpath("//*[@id='page"+i+"']");
//		driver.findElement(smartfony_page).click();
//		Thread.sleep(5000);
//		return new SmartfonyPage(driver, i);
//	}

	
}    
