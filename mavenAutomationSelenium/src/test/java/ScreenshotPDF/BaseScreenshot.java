package ScreenshotPDF;

import java.io.IOException;

import com.Demo.Home;

import mavenAutomationSelenium.BaseClass;

public class BaseScreenshot extends BaseClass {

	public static void main(String[] args) throws IOException  {
		
		lunchChrome(); 
		Home.OpenHomeURL();
		WindowSizepageScreenshot();  
		FullPagepageScreenshot(); 
		tearDownFirefox(); 
		
	}

}
