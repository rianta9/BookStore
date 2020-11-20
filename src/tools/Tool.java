package tools;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
	
	public static double toDouble(BigDecimal a) {
		double n = Double.valueOf(a.toString());
		return n;
	}
	
	public static long toLong(BigDecimal a) {
		return (long)toDouble(a);
	}

	public static boolean isEmail(String email) {
		if(email == null || email.isEmpty()) return false;
		 Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
	        return matcher.find();
	}
}
