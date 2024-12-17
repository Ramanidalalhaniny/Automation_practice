package automation_practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

	@Test (priority = 2 , enabled=false)
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

@Test (priority = 3,enabled=false)
public void Select_roll() {
	WebElement select_one=driver.findElement(By.id("dropdown-class-example"));
	Select selector= new Select(select_one);
	int random_index = rand.nextInt(1,4);
	 //selector.deselectByVisibleText("API");
	//selector.deselectByValue("option2");
	selector.selectByIndex(random_index);
	
}




@Test (priority = 4,enabled=false)
public void check_box() {
	WebElement div_select_check_box=driver.findElement(By.id("checkbox-example"));
	List <WebElement> my_check_box= div_select_check_box.findElements(By.xpath("//input[@type='checkbox']"));
	
	for( int i =0; i<my_check_box.size();i++) {
		my_check_box.get(i).click();
		
	}
}
@Test (priority = 5 , enabled=false)
public void openwindow() throws InterruptedException {
driver.findElement(By.id("openwindow")).click();
Thread.sleep(1000);
List<String>window_handels=new ArrayList<>(driver.getWindowHandles());
driver.switchTo().window(window_handels.get(1));

}
@Test (priority = 6 , enabled=false)
public void opentab() throws InterruptedException {
	driver.findElement(By.id("opentab")).click();
	List<String>window_handels=new ArrayList<>(driver.getWindowHandles());
	driver.switchTo().window(window_handels.get(1));
Thread.sleep(3000);
String Actual_result=driver.getTitle();
String expected_result="Codenbox AutomationLab - YouTube";
	
}

@Test (priority = 7, enabled=false)
public void alertbtn() throws InterruptedException {
	driver.findElement(By.id("alertbtn")).click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	
}

@Test (priority = 8 , enabled=false)
public void confirmbtn() throws InterruptedException {

driver.findElement(By.id("confirmbtn")).click();
Thread.sleep(2000);
driver.switchTo().alert().dismiss();


driver.findElement(By.id("name")).sendKeys("rama");
driver.findElement(By.id("confirmbtn")).click();
String actual_result=driver.switchTo().alert().getText();
String expected_result="Hello rama, Are you sure you want to confirm?";
Assert.assertEquals(actual_result, expected_result);
driver.switchTo().alert().accept();

}

@Test (priority = 9 , enabled=false)
public void Table() throws InterruptedException {
WebElement table= driver.findElement(By.id("product"));
List <WebElement> allcourses = table.findElements(By.tagName("td"));
for(int i=1 ; i<allcourses.size();i=i+3) {
System.out.println(allcourses.get(i).getText());	

}

}


@Test (priority = 10 , enabled=false)
public void Element_Displayed() throws InterruptedException {
driver.findElement(By.id("hide-textbox")).click();
boolean actual_result=driver.findElement(By.id("displayed-text")).isDisplayed();
boolean expected_result=false;
Assert.assertEquals(actual_result, expected_result);



driver.findElement(By.id("show-textbox")).click();
boolean actual_result2=driver.findElement(By.id("displayed-text")).isDisplayed();
boolean expected_result2=true;
Assert.assertEquals(actual_result2, expected_result2);

}

@Test (priority = 11 , enabled=false)
public void mouse_huver() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,1750)");

	Actions action= new Actions(driver);
WebElement target= driver.findElement(By.id("mousehover"));
action.moveToElement(target).perform();




}

@Test(priority = 12, enabled = false)
public void Calendar() throws InterruptedException {

	driver.findElement(By.linkText("Booking Calendar")).click();

	List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

	driver.switchTo().window(windowHandles.get(1));

	Thread.sleep(3000);
	;

	// this is the correct solution - the problem is when you try this you will get
	// error says stale element not found ( the develope is not using react or any
	// modern framework )
	// the modern Framework applies the SPA single page application

	// List<WebElement> AvailableDate=
	// driver.findElements(By.xpath("//a[@href='javascript:void(0)']"));

//	System.out.println(AvailableDate.size());

	// this is not a good solution because i have to repeat the code as much as
	// avaliable times are there

//	AvailableDate.get(1).click();
//	AvailableDate.get(2).click();
//	AvailableDate.get(3).click();

	// this will solve the problem of stale element not found but also is not a
	// correct one why because the list
	// will get declared تعرف
	// 25 times each time
	for (int i = 1; i < 25; i++) {
		List<WebElement> AvailableDate = driver.findElements(By.xpath("//a[@href='javascript:void(0)']"));

		AvailableDate.get(i).click();
		Thread.sleep(1000);
		;

	}

}

@Test(priority = 13, enabled = true)
public void iFrame() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver ; 
	
	js.executeScript("window.scrollTo(0,2400)");
	
WebElement myFrame = 	driver.findElement(By.id("courses-iframe"));


Thread.sleep(3000);
driver.switchTo().frame(myFrame);
js.executeScript("window.scrollTo(0,1100)");


String myText =driver.findElement(By.xpath("//*[@id=\"ct_heading-1b594e8\"]/div/h3/span")).getText();

System.out.println(myText);

Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"ct_button-20c391b5\"]/a/span[2]")).click();
Thread.sleep(2000);

driver.findElement(By.xpath("//*[@id=\"ct-pagetitle\"]/div/ul/li[1]/a")).click();

}


}