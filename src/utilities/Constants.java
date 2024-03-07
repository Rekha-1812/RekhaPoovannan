package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	public static String timeStamp_report = new SimpleDateFormat("dd.MM.yy-HHmmss").format(new Date());
	public static final String testDataFilePath = System.getProperty("user.dir") + "\\resources\\testdata.xlsx";
	public static final String extentreportPath = System.getProperty("user.dir") + "\\report\\ExtentReportResults.html";
	public static final String extscreenshot = System.getProperty("user.dir") + "\\report\\screenshot\\";
	public static final String url = "https://qa1-flydubai.np.flydubai.com/en/";
}
