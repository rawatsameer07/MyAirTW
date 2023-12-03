package constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarsAirElements {

	 private WebDriver driver;
	 
	 private static final String MESSAGE = "//div[@id='content']/h2[contains(text(),'%s')]";
	 private static final String LABEL_TEXT = "//div[@id='content']//label[text()='%s']";
	 private static final String DROPDOWN_DATE = "//select[@id='%s']";
	 private static final String INPUT_PROMO_CODE = "//input[@id='promotional_code']";
	 private static final String BUTTON_SEARCH = "//input[@value='Search']";
	 private static final String LOGO_MARSAIR = "//a[text()[normalize-space()='MarsAir']]";
	 private static final String SEARCH_CONTENT = "//div[@id='content']/p";
	 
	 public MarsAirElements(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	 public WebElement getWelcomeMessage() {
	        return driver.findElement(By.xpath(String.format(MESSAGE, "Welcome to MarsAir!")));
	    }
	 
	 public WebElement getRedPlanetMessage() {
	        return driver.findElement(By.xpath(String.format(MESSAGE, "Book a ticket to the red planet now!")));
	    }
	 
	  public WebElement getDepartureDropdown() {
	        return driver.findElement(By.xpath(String.format(DROPDOWN_DATE, "departing")));
	    }

	    public WebElement getArrivalDropdown() {
	        return driver.findElement(By.xpath(String.format(DROPDOWN_DATE, "returning")));
	    }
	    
	    public WebElement getDepartureLabel() {
	        return driver.findElement(By.xpath(String.format(LABEL_TEXT, "Departing")));
	    }
	 
	    public WebElement getArrivalLabel() {
	        return driver.findElement(By.xpath(String.format(LABEL_TEXT, "Returning")));
	    }
	    
	    public WebElement getPromoCodeLabel() {
	        return driver.findElement(By.xpath(String.format(LABEL_TEXT, "Promotional Code")));
	    }
	    
	    private WebElement getPromoCodeInput() {
	        return driver.findElement(By.xpath(INPUT_PROMO_CODE));
	    }
	    
	    public void setAndValdiatePromoCodeLabel(String promoCode) {
	    	WebElement promoCodeInput = getPromoCodeInput();
	    
	    	 if (promoCode.matches("[A-Z]{2}\\d-[A-Z]{3}-\\d{3}")) {
	             promoCodeInput.sendKeys(promoCode);
	             System.out.println("Promo code set successfully: " + promoCode);
	         } else {
	             System.out.println("Invalid promo code format: " + promoCode);
	         }
	       }
	    
	    WebElement searchContent = driver.findElement(By.xpath(SEARCH_CONTENT));
	    public boolean seatsAvailableMessageCheck(String expectedMessage) {
	    	 java.util.List<WebElement> paragraphs = searchContent.findElements(By.tagName("p"));
	    	 StringBuilder actualMessage = new StringBuilder();
	    	 for(WebElement paragraph: paragraphs) {
	    		 actualMessage.append(paragraph.getText()).append(" ");
	 	    }    
	    	 
	    	if(actualMessage.toString().trim().contains(SEARCH_CONTENT)) {
	    		System.out.println("Text verification successful!");
	    		return true;
	    	}
	    	else {
	    		System.out.println("Text verification failed!");
	    		return false;
	    	}
	    }
	    
	    
	   

}
