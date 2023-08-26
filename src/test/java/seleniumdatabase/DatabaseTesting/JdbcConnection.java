package seleniumdatabase.DatabaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "Pwd@mysql123@");
		
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where scenario='zerobalancecard'");
		
		while(rs.next()) 
		{
			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			
			driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("password"));
		}

	}

}
