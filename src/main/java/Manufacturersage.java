import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AvactisResources.Base;

public class Manufacturersage extends Base {
	public static Connection con;
	@BeforeTest
	public void loadBrowser() throws IOException 
	{
		initializedriver();
		driver.get("https://login.salesforce.com/?locale=in");
	}
	
	@Test()
	public static void  database() throws SQLException {
		
	String host="localhost";
	String port="3306";
	
	 con=DriverManager.getConnection("jdbc:mysql://"+ host+":"+port+"/selenium2", "root","");
	Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("select * from employeeinfo where name='sam'");
	while(rs.next()) {
		driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
		driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
		driver.findElement(By.id("Login")).click();
		System.out.println(rs.getString("username"));
		System.out.println(rs.getString("password"));
		
	}
	
	}
	
	public void teardown() throws SQLException 
	{
		con.close();
		driver.quit();
	}
}
