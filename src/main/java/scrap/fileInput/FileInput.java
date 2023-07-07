package scrap.fileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {

    private int length;

    private String path = "C:\\Users\\gamel\\Desktop\\Summer Practice Satellites Adventures\\Info\\";


    private List<String> input;

    public FileInput(String fileName) {
        receiveInput(fileName);
    }

    private void receiveInput(String fileName) {


    }

    //#TODO make it smarter smh
/*
    public void chooseType(String fileName) {
        switch (fileName) {

            case ("scrap.points.json"): {
                pointsInput(fileName);
            }

            case ("shoot.json"): {
                shootsInputJson(fileName);
            }

            case ("Ulan-Ude.txt"): {
                townInputTxt(fileName);
            }

            case ("Moscow.txt"): {
                townInputTxt(fileName);
            }

            case ("Ekaterinburg.txt"): {
                townInputTxt(fileName);
            }


        }
    }





    private void townInputTxt(String fileName) {

        this.length = 0;
        String absolutePath = path + fileName;
        input = new ArrayList<String>();
        File file = new File(absolutePath);
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
                length++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        length = length - 12;

    }





    private void shootsInputJson(String fileName) {

        this.length = 0;

        String absolutePath = path + fileName;
        input = new ArrayList<String>();
        File file = new File(absolutePath);

        String temp = "";

        try {
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()) {

                temp.concat(scanner.nextLine());
                count++;

                length++;
                if (count >= 6) {
                    System.out.println(temp);
                    input.add(temp);
                    count = 0;
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void pointsInput(String fileName) {


    }


    public String getSingleLine(int number) {

        number = number + 12;
        if (number < 0) {
            return input.get(0);
        } else
            return input.get(number);
    }


    public int getLength() {
        return length;
    }


 */
}
