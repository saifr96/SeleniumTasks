package selenium;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHighLow {
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\saifr\\Desktop\\Selenium-tasks-master\\FTSE100\\src\\test\\resources\\driver");
	        driver = new ChromeDriver();
	        driver.manage().window().setSize(new Dimension(1366, 768));
	        
	        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
        WebElement assistElement;
        List<WebElement> high = new ArrayList<WebElement>();
        List<String> store = new ArrayList<String>();
		
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100/risers%22");
        
        high = driver.findElements(By.xpath("/html/body/main/div/div/div[3]/div/div[4]/div[1]/div/table/tbody/*"));
       
        
    }
	
	@After
	public void tearDown() {
        driver.close();
    }

}
