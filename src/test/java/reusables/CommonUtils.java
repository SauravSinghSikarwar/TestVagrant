package reusables;


import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.path.json.JsonPath;

public class CommonUtils extends DriverFactory{
	
	private static WebDriverWait wait;
	public Actions builder;
	
	// for string to Json conversion
	public static JsonPath rawStringToJson(String response)
	{
		JsonPath js1 = new JsonPath(response);
		return js1;
		
	}
	
	
    // Getting only integer value from a String
	public static String extractInt(String str) 
    { 
        // Replacing every non-digit number with space  
        str = str.replaceAll("[^\\d]", " "); 
        str = str.trim(); 
  
        // Replace all the consecutive white spaces with a single space 
        str = str.replaceAll(" +", " "); 
        if (str.equals("")) 
            return "-1"; 
  
        return str; 
    } 
	
    
	// Converting Celsius value into Fahrenheit  
    public static int convertCelsiusToFahrenheit(float Celsiustemperature)
    {   
               
             int Fahrenheit =(int) (((Celsiustemperature*9)/5)+32);
       
    
        return Fahrenheit;
     
    }
    
    // method for entering data into UI edit box
    public void writeText(WebElement element, String text) {
	    	if( isElementDisplayed(element))  { 
	    		
	    		element.sendKeys(text);
	    	}
		}
    
    
    
    public boolean isElementDisplayed(WebElement webElement){

 		try{
 			wait.until(ExpectedConditions.visibilityOf(webElement));
 			webElement.isDisplayed();
 		}
 		catch(NoSuchElementException e)
 		{
 			return false;
 		}
 		
 		catch(Exception e)
 		{
 		
 			return false;
 		}
 		return true;
 	}
	
    // 
    public boolean waitForElementInVisible(WebElement webElement) {
			
			try {
				wait.until(ExpectedConditions.invisibilityOf(webElement));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
		public boolean waitForElementToClickable(WebElement webElement) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
    // Perform click by action class
    public void click_Actions(WebElement element )	
 	{
    	waitForElementToClickable(element);
    	element.click();
 	}
    
    // get webelement text 
	public String getText(WebElement webElement) {
 		return webElement.getText();
 		
 	}
	// checkbox validation
	public boolean isElementSelected(WebElement element) {
 		
 		try {
 			element.isSelected();
 		}
 		catch(NoSuchElementException e) {
 			return false;
 		}
 		return true;
 	}
}
