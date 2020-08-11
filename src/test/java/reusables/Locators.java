package reusables;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webAndAPIAutomation.GetWeatherData;

public class Locators extends CommonUtils{
	
	public Locators() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="h_sub_menu")
	WebElement subMenuLink;
	
	@FindBy(xpath ="//a[contains(text(), 'WEATHER')]")
	WebElement weatherOptionLink;
	
	@FindBy(xpath = "//h2[contains(text(), 'Welcome to Marketcube.io')]")
	WebElement registerPageHeader;
	
	@FindBy(id = "searchBox")
	WebElement citySearchBox;
	
	@FindBy(id = "Guwahati")
	WebElement guwahatiCityOption;
	
	@FindBy(xpath = "//div[@title='Guwahati']")
	WebElement titleGuwahati;
	
	@FindBy(xpath = "//span[contains(text(), 'Guwahati')]")
	WebElement cityTextInPopup;
	
	@FindBy(xpath = "//b[contains(text(), 'Temp in Degrees')]")
	WebElement temperatureValurInPopup;
	
	@FindBy(xpath = "//b[contains(text(), 'Humidity')]")
	WebElement humidityValueInPopup;
	
	
	public void getCity(String City) {	
	        click_Actions(subMenuLink);	        
	        click_Actions(weatherOptionLink);
	        waitForElementToClickable(citySearchBox);
	        writeText(citySearchBox, City);
	}
	public ArrayList<GetWeatherData> getWeatherData() {
		ArrayList<GetWeatherData> UIData= new ArrayList<GetWeatherData>();
	        waitForElementInVisible(guwahatiCityOption);
	        if(guwahatiCityOption.isSelected()) {
	        	click_Actions(titleGuwahati);
	        	waitForElementInVisible(cityTextInPopup);	        	
	    	    String city1 = getText(cityTextInPopup);
	    	    String temperature =getText(temperatureValurInPopup);
	    	    String humidity = getText(humidityValueInPopup);	    	    	
	    	    String temp = extractInt(temperature);
	    	    int itemp1 =Integer.parseInt(temp);
	    	    String humid = extractInt(humidity);
	    	    int ihumid1 =Integer.parseInt(humid);	    	   	    	    
	    	    GetWeatherData data1 = new GetWeatherData(city1,itemp1,ihumid1);
	    	    UIData.add(data1);
	        }
	        else {
	        	 waitForElementInVisible(guwahatiCityOption);
	        	 click_Actions(guwahatiCityOption);
	        	 click_Actions(titleGuwahati);
		         waitForElementInVisible(cityTextInPopup);
		         String city2 = getText(cityTextInPopup);
		    	 String temperature =getText(temperatureValurInPopup);
		    	 String humidity = getText(humidityValueInPopup);	
	    	     String temp = extractInt(temperature);
	    	     int itemp2 =Integer.parseInt(temp);	    	   
	    	     String humid = 
	    	    		 extractInt(humidity);
	    	     int ihumid2 =Integer.parseInt(humid); 
	    	    GetWeatherData data2 = new GetWeatherData(city2,itemp2,ihumid2);
	    	    UIData.add(data2);
	    	   
	}
	
	return UIData;
	}

}
