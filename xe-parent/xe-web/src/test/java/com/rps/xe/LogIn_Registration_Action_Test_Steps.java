package com.rps.xe;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.rps.xe.web.config.XeWebApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = XeWebApplication.class)
@SpringBootTest
public class LogIn_Registration_Action_Test_Steps extends AbstractPage{
	
	private static final Logger logger = LoggerFactory.getLogger(LogIn_Registration_Action_Test_Steps.class);
	public static WebDriver driver;
	
	@Value("${app.baseurl}")
	private String baseurl;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	
	@When("^User enters blank userName \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enters_blank_UserName_and_Password(String userName, String pwd) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginBtn")).click();
	}
	
	@Then("^User get error messages on Home Page$")
	public void user_get_error_message_on_home_page() throws Throwable {
		logger.info("Invalid UserName or Password");
	}
	
	@When("^User click on create account link$")
	public void click_on_create_account_link() throws Throwable {
		logger.info("Invalid UserName or Password");
	}
	
	@Then("^User navigate on Register Page with title \"([^\"]*)\"$")
	public void User_Navigate_to_Register_Page(String title) throws Throwable {
		logger.info("User Navigate to Registeration Page");
	}
	
	@When("^User enters \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" as registration fields$")
	public void do_registration(String email, String name, String lastName, String pwd) throws Throwable {
		/*driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("email")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(lastName);
		driver.findElement(By.id("pwd")).sendKeys(pwd);
		driver.findElement(By.id("signupBtn")).click();*/
		logger.info("Invalid UserName or Password");
	}
	
	@Then("^Registration is successfull and user navigated to Home Page$")
	public void registration_successfull() throws Throwable {
		logger.info("Registration is successfull and user navigated to Home Page");
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_UserName_and_Password(String userName, String pwd) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginBtn")).click();
	}

	@Then("^User Navigate to main Page$")
	public void user_navigate_to_main_page() throws Throwable {
		logger.info("User Navigate to main Page");
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		logger.info("User logout successfully");
	}

	@Then("^User is again on Home Page$")
	public void message_displayed_Logout_Successfully() throws Throwable {
		logger.info("User is again on Home Page");
	}

}