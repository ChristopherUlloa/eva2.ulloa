package eva2.ulloa.steps;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class LoginSteps {

	private WebDriver webDriver;
	private File root = new File("drivers");
	File driverPath;
	private String extensionDriver = "";
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	
	@Given("un cliente con usuario {string} y pass {string}")
	public void un_cliente_con_usuario_y_pass(String user, String pass) {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("\nSistema operativo ->"+System.getProperty("os.name").toLowerCase()+"\n");

        System.out.println("Se selecciona Chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driverPath = new File(root, "chromedriver"+extensionDriver);
        System.out.println("Se selecciona Chrome: " + driverPath.getAbsolutePath());
        System.setProperty("webdriver.chrome.driver", driverPath.getAbsolutePath());
        
        webDriver = new ChromeDriver(options);
        capabilities.setBrowserName("Chrome");
        webDriver.manage().window().maximize();
        webDriver.navigate().to("http://localhost:8080/eva2.ulloa/login.xhtml"); 
        
		webDriver.findElement(By.id("login:username")).sendKeys(user);
		webDriver.findElement(By.id("login:password")).sendKeys(pass);
	}
	
	@When("realiza el login")
	public void realiza_el_login() {
		System.out.println("Realiza Login");
		webDriver.findElement(By.id("login:ingresar")).click();	
	}
	
	@Then("Se autentica {string}")
	public void se_autentica(String msg) {
		assertEquals(webDriver.findElement(By.id("output_msg")).getText(),msg);
		System.out.println("Se autentica " + msg);
	}

} 