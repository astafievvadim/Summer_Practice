package visibilityWindow;

import satellite.Satellite;
import time.TimeWindow;

public class VisibilityWindow {

    private TimeWindow timeWindow;
    private Satellite satellite;
    private final double speed = 0.25;
    private double capacity;
    //private double Azimuth; //degrees
    //private double Elevation; //degrees
    //private String Mag; //for now it is useless; 1-10;
    //private double Distance;
    //private double SphericalAzimuth; //degrees
    //private double SphericalElevation; //degrees

    public VisibilityWindow(String part1, String part2, String part3){

    }

    private void calculateCapacity(){
        this.capacity = speed*timeWindow.getTimeInterval();
    }

    private double getCapacity(){
        return capacity;
    }
}
