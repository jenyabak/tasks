package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;


public class debug extends TopSmartSearch {

	public static WebDriver chrome_browser;
	public static String test_site = null;
	public static Object Test = null;
	
	public debug() throws IOException{

	
	}
	

	public static void main(String[] args) throws IOException{
		chrome_browser = Start_browser();
		chrome_browser.get(test_site);

		
	}


}