package logicPackage;

import pointOfInterest.PointOfInterest;
import satellite.Satellite;
import station.Station;
import time.TimeWindow;

public class Result {

        public Satellite getSatellite() {
                return satellite;
        }

        public Station getStation() {
                return station;
        }

        public PointOfInterest getPoint() {
                return point;
        }

        public TimeWindow getTimeWindow() {
                return timeWindow;
        }

        private Satellite satellite;
        private Station station;
        private PointOfInterest point;
        private TimeWindow timeWindow;
        private double time;
        private double value;

        public Result(Satellite satellite, Station station, PointOfInterest point, TimeWindow timeWindow, double timeInterval, double accumulatedData){
                this.satellite = satellite;
                this.station = station;
                this.point = point;
                this.timeWindow = timeWindow;
                this.time = timeInterval;
                this.value = accumulatedData;
        }
        // @TODO result.getTime needs rework;
        public double getTime(){
                return time;
        }

        public double getValue(){
                return value;
        }

        @Override
        public String toString(){
                return
                (satellite + "/" +
                station + "/" +
                point + "/" +
                timeWindow + "/" +
                time + "/" +
                value);
        }
}
