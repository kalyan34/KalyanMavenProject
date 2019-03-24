package TestCases;

import org.apache.http.client.fluent.Request;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;


public class TC_000 extends TestBaseSetup{	
	 WebDriver driver;
	
	 private static String PAGE_URL="https://irf.mtc.ca.gov/login";
	 	 
	 	@BeforeClass
		public void setUp() {
			driver=getDriver();
		}
   
	   @Test
	   public void Verify200ResponseTest() throws InterruptedException{		   
	       
		   //Use HTTP Client to make request and validate Response status code
	       int responseCode = getResponseCode(PAGE_URL) ;		     
		     Assert.assertEquals(responseCode, 200);
	   }
	   
	   public int getResponseCode(String url) {
	        try {
	            return Request.Get(url).execute().returnResponse().getStatusLine()
	                    .getStatusCode();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }	   
	 
}
