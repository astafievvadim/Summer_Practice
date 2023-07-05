package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeWindow {

    private int UTC;

    private Date start;
    private Date end;

    private double timeIntervalInSeconds;

    public TimeWindow(String startString, String endString, int UTC) throws ParseException {

        this.UTC = UTC;

        start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startString);
        end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endString);

        timeIntervalInSeconds = Math.abs(end.getTime()-start.getTime())/1000;
    }

    private void calculateTimeInterval() {
        //in seconds!
    }

    private void initializeFromStrings() {

    }

    public double getTimeInterval(){
        return timeIntervalInSeconds;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd(){
        return end;
    }
}
