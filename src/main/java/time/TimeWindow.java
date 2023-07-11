package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeWindow {

    private int UTC;

    private Date start;
    private Date end;

    private double timeIntervalInSeconds;

    public TimeWindow(Date startString, Date endString) throws ParseException {

        start = startString;
        end = endString;

        timeIntervalInSeconds = Math.abs(end.getTime()-start.getTime())/1000;
    }


    public TimeWindow(String startString, String endString) throws ParseException {

        start = new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse(startString);
        end = new SimpleDateFormat("dd.MM.yy HH:mm:ss").parse(endString);

        timeIntervalInSeconds = Math.abs(end.getTime()-start.getTime())/1000;
    }


    public TimeWindow(String startString, String endString, int UTC) throws ParseException {

        this.UTC = UTC;

        start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startString);
        end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endString);

        timeIntervalInSeconds = Math.abs(end.getTime()-start.getTime())/1000;
    }

    @Override
    public String toString(){
        return start + "\n" + end;
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
