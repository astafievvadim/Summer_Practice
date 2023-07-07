package scrap.fileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput_ {
/*
    private int counter;
    private List<String> input;
    private String path = "C:\\Users\\gamel\\Desktop\\Summer Practice Satellites Adventures\\Info\\";
    private static int IGNORED_LINES = 12;
    private static int JSON_IGNORED_LINES = 2;

    public FileInput_(String fileName) throws FileNotFoundException {
        this.counter = 0;
        String absolutePath = path + fileName;
        input = new ArrayList<String>();
        File file = new File(absolutePath);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
                counter++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        counter = counter - IGNORED_LINES;
    }

    public void chooseType(String fileName){
        switch(fileName) {

            case ("scrap.points.json"): {
                pointsInput(fileName);
            }

            case("shoot.json"):{
                shootsInputJson(fileName);
            }

            case("Ulan-Ude.txt"):{
                townInputTxt(fileName);
            }

            case("Moscow.txt"):{
                townInputTxt(fileName);
            }

            case("Ekaterinburg.txt"):{
                townInputTxt(fileName);
            }

            case default:{
                System.out.println("Unregistered file!");
            }

        }
    }

    private void townInputTxt(String fileName){
        this.counter = 0;
        String absolutePath = path + fileName;
        input = new ArrayList<String>();
        File file = new File(absolutePath);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
                counter++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        counter = counter - 12;
    }

    private void shootsInputJson(String fileName){
        String absolutePath = path + fileName;
        input = new ArrayList<String>();
        File file = new File(absolutePath);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
                counter++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void pointsInput(String fileName){
        counter = counter - 2;
    }

    public int getCounter() {
        return counter;
    }


    public String getOutputFromLine(int number) {
        number = number + IGNORED_LINES;
        if (number < 0) {
            return input.get(0);
        } else
            return input.get(number);
    }

    public List<String> getInput() {
        return input;
    }

 */
}


