package framework.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTool {

    public static String getTime() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH;mm;ss");
        String dateString = dateFormat.format(currentDate);
        return dateString;
    }
}
