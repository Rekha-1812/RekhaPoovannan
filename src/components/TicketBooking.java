package components;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import pageObjects.HomePage;
import utilities.ExcelUtils;
import utilities.Reusable;

public class TicketBooking extends Reusable{
	
	public void bookTicket() throws InterruptedException {
		
		ClickOn(HomePage.acceptAll_Btn);
		
		// Place selection
		String place = ExcelUtils.getCellData(1, 2);
		ClickOn(HomePage.to_TxtBox);
		InputText(HomePage.to_TxtBox, place);
		InputKeyboard_Event_ENTER(HomePage.to_TxtBox);
		Thread.sleep(2000);
		//Date selection
		By startdate = By.xpath("(//section[@class='lightpick__month'])[1]//div[contains(text(),'31')]");
		By enddate = By.xpath("(//section[@class='lightpick__month'])[2]//div[contains(text(),'30')]");
		ClickUsingActions(startdate);
		Thread.sleep(1000);
		ClickUsingActions(enddate);
		Thread.sleep(1000);
		//passenger count
		ClickOn_UsingJSE(HomePage.passengerDownArrow);
		//cabin class
		ClickOn_UsingJSE(HomePage.businessClass);// for testing
		String cabinClass = ExcelUtils.getCellData(1, 6);
		if(cabinClass.equalsIgnoreCase("Economy")) {
			ClickOn_UsingJSE(HomePage.economyClass);
		}
		Thread.sleep(2000);
		ClickOn_UsingJSE(HomePage.searchBtn);
		// choosing flight
		Waituntil(HomePage.departurelowestfareTxt, 30);
		ScrollToElement(HomePage.departurelowestfareTxt);
		ClickOn(HomePage.departure_lowestfare_DrpDwn);
		ClickOn(HomePage.visa_departureSelectBtn);
		
		Thread.sleep(5000);
		
		Waituntil(HomePage.returnlowestfareTxt, 30);
		ScrollToElement(HomePage.returnlowestfareTxt);
		ClickOn_UsingJSE(HomePage.return_lowestfare_DrpDwn);
		ClickOn(HomePage.visa_returnSelectBtn);
		
		ClickOn(HomePage.closeBtn);
		
		//selecting extras - insurance and 10kg baggage
		Waituntil(HomePage.selectextraTxt, 30);
		ScrollToElement(HomePage.baggage10kgTxt);
		ClickOn(HomePage.baggage10kgTxt);
		Thread.sleep(3000);
		ClickOn(HomePage.baggage10kgTxt);
		
		//capturing total charges for validation
		ScrollToElement(HomePage.totalAmount_ExtrasPage);
		String totalcharge = driver.findElement(HomePage.totalAmount_ExtrasPage).getText();
		totalAmount_expected = totalcharge;
		System.out.println("Expected Charge : " + totalAmount_expected);
		
		ScrollToElement(HomePage.continueToPassengerLink);
		ClickOn(HomePage.continueToPassengerLink);
		Thread.sleep(3000);
		
		//passenger details
		Waituntil(HomePage.firstname, 30);
		InputText(HomePage.firstname, "Firstname");
		InputText(HomePage.lastname, "Lastname");
		InputText(HomePage.mail, "test@test.com");
		ClickOn_UsingJSE(HomePage.malegender);
		ClickOn(HomePage.countryCode);
		ClickOn(HomePage.UAEcountryCode);
		InputText(HomePage.mobilenumber, "587676543");
		Thread.sleep(3000);
		ClickOn_UsingJSE(HomePage.reviewbooking);
		Thread.sleep(3000);
		
		//payment page
		ScrollToBottom();
		Waituntil(HomePage.totalAmount_PaymentPage, 30);
		String totalcharge_actual = driver.findElement(HomePage.totalAmount_PaymentPage).getText();
		totalAmount_actual = totalcharge_actual;
		System.out.println("Actual Charge : " + totalAmount_actual);
		
		//validation
		assertEquals(totalAmount_expected,totalAmount_actual);
		
		
		
		
	}

}
