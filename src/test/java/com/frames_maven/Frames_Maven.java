package com.frames_maven;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames_Maven {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();

		//Example 1:
		
	/*	driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		
		WebDriver frame = driver.switchTo().frame("frame1").switchTo().frame(0);
		WebElement childframe = driver.findElement(By.tagName("p"));
		String text = childframe.getText();
		System.out.println(text);
		
		WebDriver parentFrame = driver.switchTo().parentFrame();
		WebElement parenttxt= driver.findElement(By.xpath("//body[text()='Parent frame']"));
		
	String parent = parenttxt.getText();
	
	System.out.println(parent);
	
	//Example:2 -URL : https://netbanking.hdfcbank.com/netbanking/

	NOTE: Enter the userId,click continue.Enter password.

	 
	driver.get("https://netbanking.hdfcbank.com/netbanking/");
	driver.manage().window().maximize();
	WebDriver frame2 = driver.switchTo().frame(0);
	WebElement custID = driver.findElement(By.xpath("//input[@type='text']"));
	custID.sendKeys("12345");
	
	WebElement continu = driver.findElement(By.xpath("//a[@onclick='return fLogon();']"));
	continu.click();
	

	//Example:3 - URL : https://retail.onlinesbi.com/retail/login.htm

//NOTE: Click Continue To Login and click Login without enter the user id.
		
		driver.get("https://retail.onlinesbi.com/retail/login.htm");
		driver.manage().window().maximize();
		WebElement contlogin = driver.findElement(By.className("login_button"));
		contlogin.click();
		WebElement sbilogin = driver.findElement(By.id("Button2"));
		sbilogin.click();
		
		System.out.println("done");
		
		*/
		
		//Example:4 - URL : https://infinity.icicibank.com/corp/AuthenticationController?FORMSGROUP_ID__=AuthenticationFG&__START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=ICI

/*NOTE: Enter the userId password.
      Click login button*/
		
	
		
		driver.get("https://infinity.icicibank.com/corp/AuthenticationController?FORMSGROUP_ID__=AuthenticationFG&__START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=ICI");
		WebElement Loginarrow = driver.findElement(By.id("user-id-goahead"));
		Loginarrow.click();
		WebElement Icicilogin = driver.findElement(By.id("AuthenticationFG.USER_PRINCIPAL"));
		Icicilogin.sendKeys("123456");
		WebElement IciciPassword= driver.findElement(By.name("AuthenticationFG.ACCESS_CODE"));
		IciciPassword.sendKeys("Password!123");
		driver.findElement(By.id("VALIDATE_CREDENTIALS1")).click();
	}
}

