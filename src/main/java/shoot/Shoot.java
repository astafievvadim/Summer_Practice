package shoot;

import fileInput.BasicInput;
import pointOfInterest.PointOfInterest;
import satellite.Satellite;
import time.TimeWindow;

import java.text.ParseException;
import java.util.Date;

public class Shoot {

    private int id;
    private Satellite satellite;

    private PointOfInterest point;

    private int value;
    private TimeWindow timeWindow;


    public Shoot(BasicInput input, int number) throws ParseException {
        fillFromInput(input, number);
    }

    private void fillFromInput(BasicInput input, int number) throws ParseException {
        String[] aboba = input.getLine(number).split("\\s+");

        id = Integer.parseInt(aboba[3].replace(",", ""));
        satellite = new Satellite(( aboba[5] + " " + aboba[6]).replace("\"", "").replace(",", ""));
        point = new PointOfInterest((aboba[8].replace(",", "").replace("\"", "")));
        timeWindow = new TimeWindow(
                aboba[10].replace("\"", "") + " " + aboba[11].replace(" \", ", ""),
                aboba[13].replace("\"", "") + " " + aboba[14].replace(" \", ", "")
        );
        value = Integer.parseInt(aboba[16]);
    }

    @Override
    public String toString(){
        return Integer.toString(id) + " _ "+ timeWindow + " _ "+Integer.toString(value);
    }

    public TimeWindow getTimeWindow() {
        return timeWindow;
    }

    public Satellite getSatellite() {
    return satellite;
    }

    public int getData() {
        return value;
    }

    public PointOfInterest getPoint() {
        return point;
    }
}
