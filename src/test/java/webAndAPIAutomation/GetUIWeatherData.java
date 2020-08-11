package webAndAPIAutomation;

import java.io.IOException;
import java.util.ArrayList;


import reusables.DriverFactory;

public class GetUIWeatherData extends DriverFactory{
	
    public static ArrayList<GetWeatherData> getDataFromWebUI() throws IOException {    	
    	 
    	Locators.getCity("Guwahati");
    	return Locators.getWeatherData();               
    }
 
}
