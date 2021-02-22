package mavenAutomationSelenium;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {

	public static WebDriver driver; 

	public static void lunchChrome() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 
		driver.manage().window().maximize();
	}

	public static void tearDownChrome() {

		if(driver!=null) {
			driver.close();
		} else {
			System.out.println("Driver Not Found");
		}

	}


	public static void lunchFirefox() {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();

		
	}

	public static void tearDownFirefox() {

		if(driver!=null) {
			driver.close();
		} else {
			System.out.println("Driver Not Found");
		}
	}
	
	public static void WindowSizepageScreenshot() throws IOException {
		//Take Screenshot
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		
		//save file 
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Screenshot\\PageScreenshot.png"), true);
		
	}
	
	//shootingStrategy(ShootingStrategies.viewportPasting(1200).getScreenshot(driver));

	
	public static void FullPagepageScreenshot() throws IOException {
		//Take full Screenshot
		Screenshot screen=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1200)).takeScreenshot(driver); 
		ImageIO.write(screen.getImage(),"PNG",new File(System.getProperty("user.dir")+"\\Screenshot\\FullpageScreenshot.png")); 
	}


}
