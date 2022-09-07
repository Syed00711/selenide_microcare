package com.microcare.selenium.microcare_automation;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.screenshot;
public class LoginValidation {
	

	@BeforeClass
	public void setup() {
		Configuration.browser="chrome";
		//Configuration.browserSize="300x300";
		
		
	}
	
	@Test
	public void LoginPage() {
		Configuration.reportsFolder="target/Loginpage";
		open("https://www.bstackdemo.com/");
		String check = $("#__next > div > div > footer > div > div > div > span").getOwnText();
		screenshot("main_page");
		assertEquals(check,"© 2020 BrowserStack. All rights reserved.");
	}
	
	@Test
	public void Login_user_neg() {
		Configuration.reportsFolder="target/Login_user_neg1";
		open("https://www.bstackdemo.com/");
		$("#signin").click();
		$("#login-btn").click();
		screenshot("invalid_user");
		String error = $(".api-error").getOwnText();
		assertEquals("Invalid Username",error);
	}
	
	@Test
	public void Login_pass_neg() {
		Configuration.reportsFolder="target/Login_pass_neg";
		open("https://www.bstackdemo.com/");
		$("#signin").click();
		$("#username").click();
		//scteenshot
		$("#react-select-2-option-0-0").click();
		$("#login-btn").click();
		screenshot("Login_pass_neg");
		String error = $(".api-error").getOwnText();
		assertEquals("Invalid Password",error);
	}
	
	@Test
	public void Login_Positive() {
		Configuration.reportsFolder="target/Login_Positive";
		open("https://www.bstackdemo.com/");
		$("#signin").click();
		$("#username").click();
		screenshot("user_dropdown");
		//scteenshot
		$("#react-select-2-option-0-0").click();
		$("#password").click();
		$("#react-select-3-option-0-0").click();
		screenshot("password_dropdown");
		$("#login-btn").click();
		screenshot("loggedin");
		assertEquals($(".username").getOwnText(),"demouser");
		
	}

	@Test
	public void Logout() {
		Login_Positive();
		$("#logout").click();
		assertEquals($("#signin").exists(),true);
	}
	
	
}
