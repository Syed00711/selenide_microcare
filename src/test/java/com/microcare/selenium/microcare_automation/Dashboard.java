package com.microcare.selenium.microcare_automation;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Configuration.*;

public class Dashboard {
	
//	@BeforeClass
//	public void setup() {
//		Configuration.reportsFolder="build/microcare";
//	}
	
	@Test
	public void checkIphones() {
		LoginValidation lv =new LoginValidation();
		lv.Login_Positive();
		Configuration.reportsFolder="build/microcare1";
		screenshot("loggedin");
		//$("#__next > div > div > main > div.filters > div:nth-child(2) > label > span").click();
		$x("//span[text()='Apple']").click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		screenshot("clickedapple1");
		System.out.println("ietms size"+$$(".shelf-item").size());
		assertEquals($$(".shelf-item").size(),9);
	}

}
