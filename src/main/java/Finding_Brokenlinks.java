import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisResources.Base;

public class Finding_Brokenlinks extends Base {


	@BeforeTest
	public void loadBrowser() throws IOException 
	{
		initializedriver();
		driver.get("https://demo.guru99.com/selenium/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	}
	
	@Test()
	public void findBrokenLinks() throws IOException 
	{
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++) 
		{
			String url=links.get(i).getAttribute("href");
			URL link = new URL(url);
			HttpURLConnection httpconn= (HttpURLConnection) link.openConnection();
			httpconn.connect();
			int rescode=httpconn.getResponseCode();
			if(rescode>=400) 
			{
				System.out.println(url+"-"+" is a broken link");
			}
			else 
			{
				System.out.println(url+"-"+" is a valid link");
			}
		}
	}
	
}
