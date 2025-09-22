package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ecom.baseclass.BaseTest;

public class ScreenshotsUtils extends BaseTest {
	
	public String screenshotmanager(String name) {
		
		String TimeStamp= new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
		File source= ((TakesScreenshot)driver.get()).getScreenshotAs(OutputType.FILE);
		
		File destination=new File(".//Screenshots//"+name+"_"+TimeStamp+ ".png");
		try {
			FileUtils.copyFile(source, destination);
			return destination.getAbsolutePath();
		} catch (IOException e) {
			 System.out.println("Screenshot capture failed: " + e.getMessage());
			return null;
		}
		
		
	}

}
