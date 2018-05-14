package com.huicewang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Demo01 {
	
public static void main(String[] args) throws Exception{

        //如果火狐浏览器没有默认安装在C盘，需要制定其路径
//		System.setProperty("webdriver.firefox.bin", "D:/Program Files/Mozillafirefox/firefox.exe");
        WebDriver driver = new FirefoxDriver();
        
        driver.get("http://www.baidu.com/");
        driver.manage().window().maximize();
        WebElement txtbox = driver.findElement(By.name("wd"));
        txtbox.sendKeys("慧测");
        WebElement btn = driver.findElement(By.id("su"));
        btn.click();
        Thread.sleep(5000);
        driver.close();
    }

	
}

