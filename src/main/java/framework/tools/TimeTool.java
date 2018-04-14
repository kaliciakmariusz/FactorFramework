package framework.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {

    public static String getCurrentTime() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HHmmss.SSSZ");
        String dateString = dateFormat.format(currentDate);
        return dateString;
    }
}
