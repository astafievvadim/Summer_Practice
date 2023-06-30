package fileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {

    private int counter;
    private List<String> input;

    public List<String> getInput() {
        return input;
    }

    private String end = ".txt";
    private String path = "C:\\Users\\gamel\\Desktop\\Summer Practice Satellites Adventures\\Info\\";
    private static int IGNORED_LINES = 12;

    public FileInput(String fileName) throws FileNotFoundException {
        this.counter=0;
        String absolutePath = path + fileName + end;
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


}