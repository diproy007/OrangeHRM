package daashboard.steps;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dashboard.pages.DashboardPage;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class DashboardStepDef {
	
	WebDriver driver;
	DashboardPage dashPage;
	
	
	
	@Given("^dip go to Orange Hrm home page$")
	public void dip_go_to_Orange_Hrm_home_page() throws Throwable {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Drive\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	    
	}

	@When("^dip enter valid dipname and password$")
	public void dip_enter_valid_dipname_and_password() throws Throwable {
	    
		dashPage = new DashboardPage(driver);
		dashPage.enterUsernameAndPassword();
	    
	}

	@When("^dip click on the log in button$")
	public void dip_click_on_the_log_in_button() throws Throwable {
		
		dashPage.clickOnLoginButton();
	    
	}

	@Then("^dip navigate to the welcome page$")
	public void dip_navigate_to_the_welcome_page() throws Throwable {
	    
		dashPage.verifyWelcomeWord();
	    
	}

	@Then("^dip verify the page title as \"([^\"]*)\"$")
	public void dip_verify_the_page_title_as(String title) throws Throwable {
	    
		String expected = title;
		String actual = driver.getTitle();
		Assert.assertTrue("Title does not match", actual.contains(expected));
	    
	}

	@Then("^dip verify dip name is displays at top right$")
	public void dip_verify_dip_name_is_displays_at_top_right() throws Throwable {
	    
		dashPage.verifyUserName();
	}

	@Then("^dip log out$")
	public void dip_log_out() throws Throwable {
	    
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    dashPage.logOut();
	    
	}

	@Then("^dip close browser$")
	public void dip_close_browser() throws Throwable {
	    
		driver.close();
		driver.quit();
		
	    
	}}

