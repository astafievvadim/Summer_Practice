package pointOfInterest;

import fileInput.BasicInput;


public class PointOfInterest {

    private int id;
    private String label;
    private double latitude;
    private double longitude;

    public PointOfInterest(BasicInput input, int number){
        workingWithInput(input, number);
    }

    public PointOfInterest(int id, String label, double latitude, double longitude){
        this.id = id;
        this.label = label;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PointOfInterest(String label){
        this.label = label;
    }


    private void workingWithInput(BasicInput input, int number){
        String[] aboba = input.getLine(number).split("\\s+");
        id = Integer.parseInt(aboba[2].replace(",", ""));
        label = aboba[4].replace(",", "");
        latitude = Double.parseDouble(aboba[6].replace(",", ""));
        longitude = Double.parseDouble(aboba[8]);

    }

    @Override
    public String toString(){
        return (label);
    }



}
