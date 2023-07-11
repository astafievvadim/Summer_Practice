package shoot;

import com.fasterxml.jackson.core.JsonProcessingException;
import fileInput.BasicInput;
import pointOfInterest.PointOfInterest;
import satellite.Satellite;
import time.TimeWindow;

import java.text.ParseException;

public class Shoot {

    private int id;
    private Satellite satellite;

    private PointOfInterest point;

    private int volume;
    private String startTimePeriod;
    private String endTimePeriod;
    private TimeWindow timeWindow;

    private void calculateTimeWindow() throws ParseException {
        this.timeWindow = new TimeWindow(startTimePeriod, endTimePeriod);
    }
    public Shoot() throws ParseException, JsonProcessingException {
        super();
        calculateTimeWindow();
    }

    public Shoot(BasicInput input, int number) throws ParseException, JsonProcessingException {
        fillFromInput(input, number);
    }

    private void fillFromInput(BasicInput input, int number) throws ParseException, JsonProcessingException {



        String[] temp = input.getLine(number).split("\\s+");




        satellite = new Satellite(( temp[5] + " " + temp[6]).replace("\"", "").replace(",", ""));
        point = new PointOfInterest((temp[8].replace(",", "").replace("\"", "")));
        timeWindow = new TimeWindow(
                temp[10].replace("\"", "") + " " + temp[11].replace(" \", ", ""),
                temp[13].replace("\"", "") + " " + temp[14].replace(" \", ", "")
        );
        volume = Integer.parseInt(temp[16]);


    }

    private void workingWithJSON(Shoot newShoot){
        this.timeWindow = newShoot.getTimeWindow();
        this.id = newShoot.getId();
        this.volume = newShoot.getVolume();
        this.satellite = newShoot.getSatellite();
        this.point = newShoot.getPoint();
    }

    @Override
    public String toString(){
        return Integer.toString(id) + " _ "+ timeWindow + " _ "+Integer.toString(volume);
    }

    public TimeWindow getTimeWindow() {
        return timeWindow;
    }

    public Satellite getSatellite() {
    return satellite;
    }

    public int getData() {
        return volume;
    }

    public PointOfInterest getPoint() {
        return point;
    }

    public int getId() {
        return id;
    }

    public int getVolume() {
        return volume;
    }

    public String getEndTimePeriod() {
        return endTimePeriod;
    }

    public String getStartTimePeriod(){
        return startTimePeriod;
    }
}
