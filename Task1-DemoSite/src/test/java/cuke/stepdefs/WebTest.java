package cuke.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebTest {
	
	public static WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saifr\\Desktop\\SeleniumTasks-master\\DemoSite\\src\\test\\resources\\driver");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	
	}
	
	@Given("^the right web address$")
	public void the_right_web_address() throws Throwable {
	    WebElement assist;
	    driver.get("http://thedemosite.co.uk/");
	    
	    assist = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/center/big/strong"));
	    assertEquals("1. Home", assist.getText());
	    
	}

	@When("^ navigated to the 'Add a User' page$")
	public void navigate_to_the_Add_a_User_page() throws Throwable {
		WebElement assist;
		
		assist = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
	    assist.click();
	    
	    assertEquals("3. Add a User", driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/p[1]/big/strong")).getText());
		
	}


	@Then("^ generate a new user using the following$")
	public void generate_a_new_user_using_the_following(DataTable arg1) throws Throwable {
		WebElement assist;
		
		List<List<String>> listData = arg1.raw();
		List<String> userInfo = listData.get(1);
		
		assist = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		assist.sendKeys(userInfo.get(0));
		
		assist = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		assist.sendKeys(userInfo.get(1));
		
		assist = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		assist.click();
		
	}
	
	@Then("^login using the new credentials$")
	public void login_using_the_new_credentials(DataTable arg1) throws Throwable {
	 
		WebElement assist;
		
		assist = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		assist.click();
		
		assertEquals("4. Login", driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/p[1]/big/strong")).getText());
	    
		List<List<String>> listData = arg1.raw();
		List<String> userInfo = listData.get(1);
		
		assist = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		assist.sendKeys(userInfo.get(0));
		
		assist = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		assist.sendKeys(userInfo.get(1));
		
		assist = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		assist.click();
		
		assertEquals("**Successful Login**", driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
		
	}

	
	@After
	public void cleanup() {
		driver.close();
		driver.quit();
	}

}
