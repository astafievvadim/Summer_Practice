package fileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BasicInput {

    private String stationName;
    private List<String> input;
    private String path = "C:\\Users\\gamel\\Desktop\\Summer Practice Satellites Adventures\\Info\\";

    public int getSize(){
        return input.size();
    }

    public BasicInput(String fileName) throws FileNotFoundException {
        input = new ArrayList<String>();
        chooseType(fileName);

    }

    public String getStationName() {
        return stationName;
    }

    public String getLine(int number){
        return input.get(number);
    }

    public List<String> getInput(){
        return input;
    }

    public void chooseType(String fileName) {
        switch (fileName) {
            case ("points.json"): {

                pointsInput(fileName);
                reformatForPoint();
                return;
            }

            case ("shoot.json"): {
                shootsInputJson(fileName);
                reformatForShoot();
                return;
            }

            case ("Ulan-Ude.txt"):

            case ("Moscow.txt"):

            case ("Ekaterinburg.txt"): {
                townInputTxt(fileName);
                reformatForTown();
                stationName = fileName.replace(".txt", "");
            }


        }
    }

    private void reformatForTown() {
        int i = 0;
        while(i <12){
            input.remove(0);
            i++;
        }
    }

    private void reformatForShoot() {

        List<String> temp = new ArrayList<>();

        String tempString = "";
        int x = input.size();
        for(int j = 7; j<x; j = j+8) {
            tempString = input.get(j-6)  + "\n" + input.get(j-5) + "\n" + input.get(j-4)+ "\n"  + input.get(j-3)+ "\n" + input.get(j-2) + "\n" + input.get(j-1)+ "\n"  + input.get(j)+ "\n"  + input.get(j+1).replace(",", "");;

            temp.add(tempString);
        }

        this.input = temp;
        System.out.println(input.get(0));
    }


    private void townInputTxt(String fileName) {

        String absolutePath = path + fileName;
        File file = new File(absolutePath);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void shootsInputJson(String fileName) {
        String absolutePath = path + fileName;
        File file = new File(absolutePath);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }


            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void pointsInput(String fileName) {
        String absolutePath = path + fileName;
        File file = new File(absolutePath);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                    input.add(scanner.nextLine());
                }


            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    // 0 - 0, 1, 2, 3, 4, 5,
    // 1 - 6, 7, 8, 9, 10, 11
    // 2 - 12, 13, 14, 15,16, 17
    //#TODO find the problem
    private void reformatForPoint(){



        List<String> temp = new ArrayList<>();
        String tempString = " ";
        int x = input.size();
            for(int j = 5; j<x; j = j+6){

                tempString = input.get(j-3) + input.get(j-2) + input.get(j-1) + input.get(j);
                    temp.add(tempString);
                }

        this.input = temp;

    }

}
