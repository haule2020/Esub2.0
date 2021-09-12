package managers;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class baseMethod {

	public String getDateTime(String dtformat) throws Exception {

		DateFormat dateformat = new SimpleDateFormat(dtformat);
		Calendar cal = Calendar.getInstance();
		return dateformat.format(cal.getTime());
	}

	// mrkdir
	public void mkdir(String outputPath) {
		try {
			File output = new File(outputPath);
			output.mkdir();
		} catch (Exception e) {
		}
	}

}
