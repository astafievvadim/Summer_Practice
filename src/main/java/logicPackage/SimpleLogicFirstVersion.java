package logicPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import satellite.Satellite;
import shoot.Shoot;
import visibilityWindow.VisibilityWindow;

import java.util.*;

public class SimpleLogicFirstVersion {

    private Data data;

    private double receivedValue;

    public double getReceivedValue() {
        return receivedValue;
    }

    public double getWastedTime() {
        return wastedTime;
    }

    private double wastedTime;
    private ObservableList<Result> results;

    public SimpleLogicFirstVersion(Data data){
        this.data = data;

        results = FXCollections.observableArrayList();

        scanSingleSatellite(new Satellite("satellite 1-9"));
        scanSingleSatellite(new Satellite("satellite 1-8"));
        scanSingleSatellite(new Satellite("satellite 1-7"));
        scanSingleSatellite(new Satellite("satellite 1-6"));
        scanSingleSatellite(new Satellite("satellite 1-5"));
        scanSingleSatellite(new Satellite("satellite 1-4"));
        scanSingleSatellite(new Satellite("satellite 1-3"));
        scanSingleSatellite(new Satellite("satellite 1-2"));
        scanSingleSatellite(new Satellite("satellite 1-1"));

        calculateTime();
        calculateValue();
    }

    private void calculateValue(){
        for(int i = 0; i < results.size(); i++) {
            receivedValue += results.get(i).getValue();
        }
    }

    private void calculateTime(){
        for(int i = 0; i < results.size(); i++) {
            wastedTime += results.get(i).getTime();
        }
    }

    public void printResults(){

        for(int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        System.out.println(receivedValue + " - value");

        System.out.println(wastedTime + " - time");
    }

    private boolean shouldShoot(double accumulatedData, int newData, double closestStCapacity){
        return (closestStCapacity > newData + accumulatedData) ;
    }

    private void scanSingleSatellite(Satellite satellite){

         List<Shoot> shootsForThisSatellite = data.getAllShootsFor(satellite);
         List<VisibilityWindow> visWindForThisSatellite = data.getAllWindowsFor(satellite);
         double accumulatedData = 0;

         for(int i = 0; i < shootsForThisSatellite.size(); i++){

            Shoot temp = shootsForThisSatellite.get(i);
            if(i >= visWindForThisSatellite.size()) {
               return;
            }
             VisibilityWindow closestVisibilityWindow = getClosestVisibilityWindow(temp, visWindForThisSatellite, i);

            if (shouldShoot(accumulatedData, temp.getData(), closestVisibilityWindow.getReceivingCapacity())) {
                accumulatedData = accumulatedData + temp.getData();
            }

            if ((accumulatedData <= closestVisibilityWindow.getReceivingCapacity())){


                 results.add(new Result(
                 satellite,
                 closestVisibilityWindow.getStation(),
                 //data.getPoints().get(),
                         temp.getPoint(),
                 temp.getTimeWindow(),
                 temp.getTimeWindow().getTimeInterval(),
                 accumulatedData));
                 accumulatedData = 0;
            }
         }
    }

    private VisibilityWindow getClosestVisibilityWindow(Shoot shoot, List<VisibilityWindow> a, int id) {
        return a.get(id);
    }


    public ObservableList<Result> getResult() {
        return results;
    }
}
