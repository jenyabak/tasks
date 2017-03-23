package test;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import helper.GetPropertyValues;
import helper.DB_SQLite;
import pages.BasePage;
import pages.SmartfonyPage;



public class TopSmartSearch {

//	public WebDriver driver;
//	public String test_site = null;
	
	public static WebDriver driver = null;
	public static String test_site_url = null;
	public static BasePage homePage = null;
	public static SmartfonyPage smartfony = null;
	

	public TopSmartSearch() throws IOException{
//		driver = null;
//    	String  path_to_chromedriver = new GetPropertyValues().getPropValues("path_to_chromedriver");
//		System.setProperty("webdriver.chrome.driver", path_to_chromedriver);
		
	//	test_site = new GetPropertyValues().getPropValues("test_site");
		//System.setProperty("test_site", test_site);
		
	
		}
	
	
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

//	public WebDriver Start_browser(){
//		this.driver = new ChromeDriver();
//		return this.driver;
//	}
//	
	
	public static WebDriver Start_browser() throws IOException{
    	String  path_to_chromedriver = new GetPropertyValues().getPropValues("path_to_chromedriver");
    	System.setProperty("webdriver.chrome.driver", path_to_chromedriver);
		driver = new ChromeDriver();
		return driver;
	}
	
//	public static WebDriver Open_page(String test_site) throws IOException{
//		driver.get(test_site_url);
//		return driver;
//	}
	
	public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException{
		//
		String  path_to_sqlite_db = new GetPropertyValues().getPropValues("path_to_sqlite_db");
		//DB_SQLite.ConnectDB(path_to_sqlite_db); //DB_SQLite.CreateDB_Table();
		
		DB_SQLite db = new DB_SQLite(path_to_sqlite_db);
		
		Start_browser();
		driver.manage().window().maximize();
		//
		
		BasePage start_page = new BasePage(driver);
		smartfony = start_page.GotoHomePage(driver).goto_telefony_tv_i_ehlektronika(driver).goto_telefony(driver).goto_smartfony(driver);

		
		 for (int i = 0; i <= 32; i++) {
		 if(smartfony.smartfon_is_top(i)){
			 //System.out.println(smartfony.get_smartfon_name(i)+"  "+smartfony.get_smartfon_price(i));
			 db.Write(smartfony.get_smartfon_name(i),smartfony.get_smartfon_price(i));
		 }
		}
		 
		 smartfony.goto_smartfony_page2(driver);
		 for (int i = 0; i <= 32; i++) {
		 if(smartfony.smartfon_is_top(i)){
			 //System.out.println(smartfony.get_smartfon_name(i)+"  "+smartfony.get_smartfon_price(i));
			 db.Write(smartfony.get_smartfon_name(i),smartfony.get_smartfon_price(i));
		 }
		}
		 
		 smartfony.goto_smartfony_page3(driver);
		 for (int i = 0; i <= 32; i++) {
		 if(smartfony.smartfon_is_top(i)) {
			 //System.out.println(smartfony.get_smartfon_name(i)+"  "+smartfony.get_smartfon_price(i));
			 db.Write(smartfony.get_smartfon_name(i),smartfony.get_smartfon_price(i));
		 }
		} 
		 db.Read();
		 db.Close();
		 driver.close();

	}
	

}