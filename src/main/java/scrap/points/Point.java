package scrap.points;

import scrap.fileInput.FileInput_;

public class Point {

    private int id;
    private String label;
    private double latitude;
    private double longitude;


    public Point(){

    }

    private void inputFiller(FileInput_ input){
        int counter = 0;
        this.id = 0; // first line;
    }

}
