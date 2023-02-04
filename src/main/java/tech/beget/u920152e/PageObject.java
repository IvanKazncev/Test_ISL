package tech.beget.u920152e;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public record PageObject(WebDriver webDriver) {
     public static final String StartURL = "http://u920152e.beget.tech/";
     public static final String Avitorization = "form_auth_block_head_text";
     public static final String Email = "auth_email";
     public static final String Password = "auth_pass";
     public static final String Submit_Button = "form_auth_button";
     public static final String Age = "form_auth_style";





     public void Start(){
         webDriver.get(StartURL);
     }

}
