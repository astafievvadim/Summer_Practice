package logicPackage;

import time.TimeWindow;
import java.text.ParseException;
import java.util.Date;

public class TimeComparator implements java.util.Comparator<Result>{

    @Override
    public int compare(Result resultA, Result resultB) {

        Date a = resultA.getTimeWindow().getStart();
        Date b = resultB.getTimeWindow().getStart();

        TimeWindow newWindow;
        try {
            newWindow = new TimeWindow(a, b);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return a.compareTo(b);
    }
}
