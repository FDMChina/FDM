import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When;
 
public class Login { 
	WebDriver driver = null;
 
	@Given("^I am on the login page$")
	public void goToLogin() { 
		driver = new ChromeDriver();
		driver.navigate().to("https://http://localhost:8081/#/login");
	} 
 
	@When("^I enter username as \"(.*)\"$")
	public void enterUsername(String arg1) { 
		driver.findElement(By.id("username")).sendKeys(arg1); 
	}
 
	@When ("^I enter password as \"(.*)\"$") 
	public void enterPassword(String arg1) { 
		driver.findElement(By.id("password")).sendKeys(arg1); 
		driver.findElement(By.className("login")).click(); 
	}
	
	@Then("^Login should succeed$")
	public void checkSucceed() { 
		if(driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8081/#/dashboard")){
			System.out.println("Test1 Pass"); 
		} 
		else { 
			System.out.println("Test1 Failed"); 
		} 
		driver.close(); 
	 	}
	
	
}
