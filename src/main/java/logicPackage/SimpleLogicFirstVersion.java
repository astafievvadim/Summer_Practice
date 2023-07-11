package logicPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import satellite.Satellite;
import shoot.Shoot;
import visibilityWindow.VisibilityWindow;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SimpleLogicFirstVersion {

    private Data data;

    private double receivedValue;
    private boolean shouldClear;

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
        receivedValue = 0;
        for(int i = 0; i < results.size(); i++) {
            receivedValue += results.get(i).getValue();
        }
    }

    private void calculateTime(){
        wastedTime = 0;
        for(int i = 0; i < results.size(); i++) {
            wastedTime += results.get(i).getTime();
        }
        wastedTime = (int)wastedTime/3600;
    }

    public void printResults(){

        for(int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        System.out.println(receivedValue + " - value");

        System.out.println(wastedTime + " - time");
    }

    public void clearForStation() {

        List<Result> temp = results;
        Collections.sort(temp, new TimeComparator());
        Result mustBeRemoved;
        for (int i = 1; i < temp.size() - 1; i++) {
            if ((isOverlapping(
                    temp,
                    i,
                    i - 1
            ))) {

                if (temp.get(i).getValue() == lowestValue(
                        temp.get(i).getValue(),
                        temp.get(i - 1).getValue()
                )) {
                    mustBeRemoved = temp.get(i);


                } else {
                    mustBeRemoved = temp.get(i - 1);
                }
                temp.remove(mustBeRemoved);
            }
                if ((isOverlapping(
                        temp,
                        i,
                        i + 1
                ))) {
                    if (temp.get(i).getValue() == lowestValue(
                            temp.get(i).getValue(),
                            temp.get(i + 1).getValue()
                    )) {
                        mustBeRemoved = temp.get(i);



                    } else {
                        mustBeRemoved = temp.get(i + 1);

                    }
                    temp.remove(mustBeRemoved);
                }
            }

        calculateTime();
        calculateValue();

        }


    private boolean isOverlapping(List<Result> temp, int i, int iNext) {
        Date startFirst = temp.get(i).getTimeWindow().getStart();
        Date endFirst = temp.get(i).getTimeWindow().getEnd();

        Date startSecond = temp.get(iNext).getTimeWindow().getStart();
        Date endSecond = temp.get(iNext).getTimeWindow().getEnd();

        return !startFirst.after(endSecond) && !startSecond.after(endFirst);
    }



    private double lowestValue(double valueA, double valueB){
        double lValue = Math.min(valueA, valueB);
        return lValue;
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
