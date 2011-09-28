
package com.goc;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ExampleTest {
	
	WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
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
