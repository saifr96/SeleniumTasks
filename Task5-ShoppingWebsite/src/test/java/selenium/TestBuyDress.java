package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBuyDress {
	
private WebDriver driver;
	
	@Before
	public void setup() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\saifr\\Desktop\\Selenium-tasks-master\\ShoppingWebsite\\src\\test\\resources\\driver");
	        driver = new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));
	}
	
	@Test
	public void test() throws InterruptedException {
        WebElement searchBar;
        WebElement found;
        
        String dress = "dress";
        String mail = "vbvbnvb@gmail.com";
		
		driver.get("http://automationpractice.com/index.php");
        
        //Find searchbar
		searchBar = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]"));
        searchBar.sendKeys(dress);
        searchBar.submit();	
        Thread.sleep(1000);
        
        //Find a particular dress and add to cart
        found = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
        found.click();
        Thread.sleep(1000);
        found = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[4]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button"));
        found.submit();
        Thread.sleep(1000);
   
        
        //Hit proceed to checkout
        found = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]"));
        found.click();
        Thread.sleep(1000);
               
        //Add mail
        found = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[2]/input"));
        found.sendKeys(mail);
        found.submit();
        Thread.sleep(2000);
        
       
        
        //assertEquals("Printed Dress", found.getText());
    }
	
	@After
	public void tearDown() {
        driver.close();
    }

}


