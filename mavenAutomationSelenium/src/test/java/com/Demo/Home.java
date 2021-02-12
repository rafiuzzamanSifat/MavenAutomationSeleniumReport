package com.Demo;

import mavenAutomationSelenium.BaseClass;

public class Home extends BaseClass {

	public static void main(String[] args) {
		
		lunchChrome();

	}
	
	public static void OpenHomeURL() {

		driver.get("https://demo.opencart.com/");
		
	}

}
