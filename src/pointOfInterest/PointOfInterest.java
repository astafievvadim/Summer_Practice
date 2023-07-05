package pointOfInterest;

public class PointOfInterest {

    private int id;
    private String label;
    private double latitude;
    private double longitude;

    public PointOfInterest(int id, String label, double latitude, double longitude){
        this.id = id;
        this.label = label;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
