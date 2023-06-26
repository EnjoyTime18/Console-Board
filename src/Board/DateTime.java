package Board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

	public static String PostDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		return format.format(time);
	}
}
