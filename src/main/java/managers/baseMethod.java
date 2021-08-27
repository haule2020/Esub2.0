package managers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class baseMethod {

	public String getDateTime(String dtformat) throws Exception {

		DateFormat dateformat = new SimpleDateFormat(dtformat);
		Calendar cal = Calendar.getInstance();
		return dateformat.format(cal.getTime());
	}

}
