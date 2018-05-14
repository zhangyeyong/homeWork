package com.huicewang;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public class Demo02 {

	public static void main(String[] args) throws Exception {
//		FirefoxDriver driver = new FirefoxDriver();
		
//		FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
//		FirefoxDriver driver = new FirefoxDriver(binary, null);
		
//		FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\zach\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\2jdk1gzi.default"));
//		FirefoxDriver driver = new FirefoxDriver(profile);
		
//		ProfilesIni prof = new ProfilesIni();
//		FirefoxDriver driver = new FirefoxDriver(prof.getProfile("default"));
		
		//修改首页默认网址
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.startup.homepage","http://www.huicewang.com/ecshop");		
//		profile.setPreference("browser.startup.page","1");

		//设置浏览器代理
//		// 使用代理
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("network.proxy.type", 1);
//		// http协议代理配置
//		profile.setPreference("network.proxy.http", "127.0.0.1");  
//		profile.setPreference("network.proxy.http_port", 8888);
//		profile.setPreference("network.proxy.ssl", "127.0.0.1");  
//		profile.setPreference("network.proxy.ssl_port", 443);  
//		// 所有协议公用一种代理配置，如果单独配置，这项设置为false
//		profile.setPreference("network.proxy.share_proxy_settings", true); 
//		// 对于localhost的不用代理，这里必须要配置，否则无法和webdriver通讯
//		profile.setPreference("network.proxy.no_proxies_on", "127.0.0.1");
	    
	    
		//无提示默认路径下载
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.download.dir", "d:\\");	
////		设置Firefox的默认 下载 文件夹 0是桌面；1是“我的下载”；2是自定义
//		profile.setPreference("browser.download.folderList", 2);	
//		profile.setPreference("browser.download.manager.showWhenStarting", false);
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream, application/vnd.ms-excel, text/csv, application/zip");
//		FirefoxDriver driver = new FirefoxDriver(profile);
//		driver.get("http://storage.360buyimg.com/jdmobile/JDMALL-PC2.apk");
		
//		//自动收集页面加载时序图
		FirefoxProfile profile = new FirefoxProfile();
		profile.addExtension(new File("source\\firebug-2.0.17.xpi"));
		profile.addExtension(new File("source\\netExport-0.8.xpi"));
		
		profile.setPreference("extensions.firebug.allPagesActivation", "on");
		profile.setPreference("extensions.firebug.net.enableSites", "true");
		profile.setPreference("extensions.firebug.defaultPanelName", "net");
		profile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", "true");
		profile.setPreference("extensions.firebug.netexport.saveFiles", "true");
		profile.setPreference("extensions.firebug.netexport.defaultLogDir", "d:\\");
		FirefoxDriver driver = new FirefoxDriver(profile);
		Thread.sleep(2000);
		driver.get("http://www.huicewang.com");
		driver.get("http://www.baidu.com");
		
	}
}
