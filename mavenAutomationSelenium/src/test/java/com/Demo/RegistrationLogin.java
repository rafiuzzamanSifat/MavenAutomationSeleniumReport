package com.Demo;
import java.io.IOException;

import mavenAutomationSelenium.BaseClass;

public class RegistrationLogin extends BaseClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		lunchChrome(); 
		Home.OpenHomeURL();
		Register.OpeRegistration(); 
		Register.register(); 
		Login.OpenLoginURL(); 
		Login.ValidEmailValidPass();
		//tearDownChrome(); 
		
		
	}

}
