package sampleLogin_pom.tests;

import org.testng.annotations.Test;

import sampleLogin_pom.pages.LoginPage;

public class LoginTest extends BaseTest{
  @Test
  public void loginToHerokuapp() {
	  LoginPage page = new LoginPage(driver);
	  page.goToPage().setTextValue(page.UserNameField,"tomsmith").setTextValue(page.PasswordField,"SuperSecretPassword!").clickLogin();
  }
}
