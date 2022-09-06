package com.microcare.selenium.microcare_automation;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Configuration.*;

public class Dashboard {
	
	@BeforeClass
	public void setup() {
		Configuration.reportsFolder="build/microcare";
	}
	
	@Test
	public void checkIphones() {
		LoginValidation lv =new LoginValidation();
		lv.Login_Positive();
		screenshot("loggedin");
		//$("#__next > div > div > main > div.filters > div:nth-child(2) > label > span").click();
		$x("//span[text()='Apple']").click();
		screenshot("clickedapple");
		System.out.println("ietms size"+$$(".shelf-item").size());
		assertEquals($$(".shelf-item").size(),9);
	}

}
