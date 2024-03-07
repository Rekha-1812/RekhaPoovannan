package testsuite;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import components.TicketBooking;
import utilities.Constants;
import utilities.ExcelUtils;
import utilities.Reusable;


public class TicketBookingMain extends Reusable{
	
	@BeforeTest
	public void beforeExecution() throws IOException, InterruptedException {
		
	}

	@Test
	public void bookingTicketModule() throws IOException, InterruptedException, AWTException {

		Launch_Browser_and_Application(Constants.url);
		ExcelUtils.setExcelFile(Constants.testDataFilePath, "TicketBooking");
		TicketBooking tb = new TicketBooking();
		tb.bookTicket();		

	}

	@AfterTest
	public void afterExecution() throws IOException, InterruptedException {
		driver.close();
	}

}
