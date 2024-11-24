package automation_practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class My_test_case_automation_practice {
	WebDriver driver = new ChromeDriver();
	String website="https://codenboxautomationlab.com/practice/";
	Random rand = new Random();
	
	
	@BeforeTest
	public void MySetup() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(website);
	}
	
	@Test (priority = 1,enabled=false)
	public void radio_buttons() {
	WebElement div_radio = 	driver.findElement(By.id("radio-btn-example"));
	int random_index = rand.nextInt(div_radio.findElements(By.tagName("input")).size());
	WebElement selected_input=div_radio.findElements(By.tagName("input")).get(random_index);
	selected_input.click();
	boolean actual_result=selected_input.isSelected();
	boolean expected_result=true;
	Assert.assertEquals(actual_result, expected_result);
	}

	@Test (priority = 2)
	public void dynamic_drop_down() throws InterruptedException {
		String[] my_random_caracter = {
	            "AU", "BR", "CA", "DE", "EG",
	            "FR", "GE", "HU", "IN", "JA",
	            "KE", "LE", "ME", "NO", "OM",
	            "PA", "QA", "RU", "SP", "TU",
	            "UK", "VI", "YE", "ZI"
	        };int random_index= rand.nextInt(my_random_caracter.length);
String my_input_data= my_random_caracter[random_index];

WebElement autocomplete_input=driver.findElement(By.id("autocomplete"));	
autocomplete_input.sendKeys(my_input_data);
Thread.sleep(1000);
autocomplete_input.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
JavascriptExecutor js = (JavascriptExecutor) driver;
String data_inside_my_input= (String) js.executeScript("return arguments[0].value",autocomplete_input );
String apdated_data=data_inside_my_input.toLowerCase();
boolean Actual_ressult=apdated_data.contains(my_input_data.toLowerCase());
Assert.assertEquals(Actual_ressult, true);

	}

@Test (priority = 3)
public void Select_roll() {
	WebElement select_one=driver.findElement(By.id("dropdown-class-example"));
	Select selector= new Select(select_one);
	int random_index = rand.nextInt(1,4);
	 //selector.deselectByVisibleText("API");
	//selector.deselectByValue("option2");
	selector.selectByIndex(random_index);
	
}}