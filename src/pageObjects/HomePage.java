package pageObjects;

import org.openqa.selenium.By;

public class HomePage  {
	
	public static By acceptAll_Btn = By.xpath("//button[contains(@class,'accept')]");
	public static By to_TxtBox = By.xpath("(//input[@id='airport-destination'])[1]");
	public static By startMonth = By.xpath("(//strong[@class='month-item-name'])[3]");
	public static By returnMonth = By.xpath("(//strong[@class='month-item-name'])[4]");
	public static By nextMonthArrow = By.xpath("(//button[@class='button-next-month'])[4]");
	public static By passengerDownArrow = By.xpath("(//div[@id='travellerData'])[1]");
	public static By adultIncrement = By.xpath("//div[@class='plus adult']");
	public static By economyClass = By.xpath("//label[contains(text(),'Economy')]");
	public static By businessClass = By.xpath("//label[contains(text(),'Business')]");
	public static By searchBtn = By.xpath("(//input[@value='Search'])[1]");
	public static By departurelowestfareTxt = By.xpath("//label[contains(text(),'Lowest fare')]");
	public static By departure_lowestfare_DrpDwn = By.xpath("//label[contains(text(),'Lowest fare')]//ancestor::fz-static-label//parent::div//following-sibling::div//div[@class='flight-accord-icon ng-star-inserted']//img");
	public static By visa_departureSelectBtn = By.xpath("//label[contains(text(),'Value')]//ancestor::div[@class='fare-brand-heading']//following-sibling::div[@class='Value fare-faretype']/descendant::button");

	public static By returnlowestfareTxt = By.xpath("(//label[contains(text(),'Lowest fare')])[2]");
	public static By return_lowestfare_DrpDwn = By.xpath("(//label[contains(text(),'Lowest fare')]//ancestor::fz-static-label//parent::div//following-sibling::div//div[@class='flight-accord-icon ng-star-inserted']//img)[2]");
	public static By visa_returnSelectBtn = By.xpath("//label[contains(text(),'Value')]//ancestor::div[@class='fare-brand-heading']//following-sibling::div[@class='Value fare-faretype']/descendant::button");

	public static By closeBtn = By.xpath("//a[contains(text(),'×')]");
	
	public static By selectextraTxt = By.xpath("//label[contains(text(),'Select extras')]");
	public static By baggage10kgTxt = By.xpath("//label[@class='three-baggage-pallate ng-star-inserted' and contains(text(),'+10 KG')]");
	public static By continueToPassengerLink = By.xpath("//span[contains(text(),'Continue to passenger details')]//parent::a");
	
	public static By totalAmount_ExtrasPage = By.xpath("//div[@class='totalNpr']//descendant::label[@id='lblAmount']");

	public static By firstname = By.id("First_Name");
	public static By lastname = By.id("Last_Name");
	public static By mail = By.id("Email_Address");
	public static By malegender = By.xpath("//input[@type='radio' and @value='Male.Text']");
	public static By femalegender = By.xpath("//input[@type='radio' and @value='Female.Text']");
	public static By countryCode = By.xpath("//input[@id='Code']/parent::div/descendant::img");
	public static By UAEcountryCode = By.xpath("//span[@id='countryValueCode' and contains(text(),'United Arab Emirates')]");
	public static By mobilenumber = By.id("Mobile_Number");
	
	public static By journeydetails_Txt = By.xpath("//label[contains(text(),'Journey total')]");
	public static By reviewbooking = By.xpath("//span[contains(text(),'Review booking')]//ancestor::button");
	
	public static By totalAmount_PaymentPage = By.xpath("//div[@id='totalAmount']//descendant::label[@id='lblAmount']");
}
