package visibilityWindow;

import fileInput.BasicInput;
import satellite.Satellite;
import station.Station;
import time.TimeWindow;

import java.sql.Time;
import java.text.ParseException;

public class VisibilityWindow {

    private Station station;
    private TimeWindow timeWindow;
    private Satellite satellite;
    private final double speed = 0.25;
    private double receivingCapacity;



    //private double Azimuth; //degrees
    //private double Elevation; //degrees
    //private String Mag; //for now it is useless; 1-10;
    //private double Distance;
    //private double SphericalAzimuth; //degrees
    //private double SphericalElevation; //degrees

    public VisibilityWindow(BasicInput input, int number) throws ParseException {
        fillFromInput(input, number);
        calculateCapacity();
    }

    private void fillFromInput(BasicInput input, int number) throws ParseException {

        String[] beautifulFirst = input.getLine(number).split("\\s+");

        String[] beautifulSecond = input.getLine(number+2).split("\\s+");


        timeWindow = new TimeWindow(
                beautifulFirst[0] + " " + beautifulFirst[1],
                beautifulSecond[0] + " " + beautifulSecond[1] ,
                4);

        satellite = new Satellite(beautifulFirst[2] + " " + beautifulFirst[3]);

        station = new Station(input.getStationName());


    }

    @Override
    public String toString(){
        return timeWindow + " _ " + satellite + " _ " + station;
    }


    public Station getStation() {
        return station;
    }

    public TimeWindow getTimeWindow() {
        return timeWindow;
    }

    private void calculateCapacity(){
        this.receivingCapacity = speed*timeWindow.getTimeInterval();
//#TODO cleanup this \/
        /*
        System.out.println(timeWindow);
        System.out.println(Double.toString(speed) + " * " + Double.toString(timeWindow.getTimeInterval()) + " = " + receivingCapacity);

         */
    }

    public double getReceivingCapacity(){
        return receivingCapacity;
    }
    public Satellite getSatellite(){
        return satellite;
    }
}
