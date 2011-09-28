
package com.goc;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ExampleTestNgTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
 
    @Test
    public void testSelenium() throws Exception {
        WebElement username = driver.findElement(By.name("login"));
        WebElement password = driver.findElement(By.name("password"));
        username.sendKeys("rsadmin");
        password.sendKeys("changeme");
        username.submit();
        try{
        	driver.findElement(By.id("rsUser"));
        }catch(Exception e){
        	Assert.fail("Could not login. Exception: " + e.toString());
        }
    }
    
}
