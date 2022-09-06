package com.microcare.selenium.microcare_automation;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.annotations.Report;

import static com.codeborne.selenide.Condition.*;

/**
 * Selenium automation test for simple App.
 */
@Report
public class LoginTest 
    
{
	
	@BeforeTest
	public void config() {
		 Configuration.browser ="safari";
		// Configuration.browserBinary="/Users/sh030348/Downloads";
		 Configuration.baseUrl="https://www.bstackdemo.com/";
		 Configuration.webdriverLogsEnabled=true;
	}
	
	@Test
	public void Login_negative_password() {
		open("https://www.bstackdemo.com/");
		$("#signin").click();
		$("#username > div > div.css-1wy0on6 > div").click();
		$("#react-select-2-option-0-0").click();
		$("#login-btn").click();
		String error =$(".api-error").getOwnText();
		assertEquals("Invalid Password", error);
		
		
	}
	
	@Test
	public void Login_negative_userame() {
		open("https://www.bstackdemo.com/");
		$("#signin").click();
		$("#login-btn").click();
		String error =$(".api-error").getOwnText();
		assertEquals(error,"Invalid Username");
		
	}
	
	
	
	
	@Test
	public void Login_positve() {
		open("https://www.bstackdemo.com/");
		$("#signin").click();
		$("#username > div > div.css-1wy0on6 > div").click();
		$("#react-select-2-option-0-0").click();
		$("#password > div > div.css-1wy0on6 > div > svg").click();
		$("#react-select-3-option-0-0").click();
		$("#login-btn").click();
		assertEquals($(".username").getOwnText(), "demouser");
	}
   
}
