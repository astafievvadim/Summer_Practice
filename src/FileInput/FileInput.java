package FileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {

    private List<String> input;
    private String end = ".txt";
    private String path = "C:\\Users\\gamel\\Desktop\\Summer Practice Satellites Adventures\\Info\\";


    public FileInput(String fileName) throws FileNotFoundException {
        String absolutePath = path + fileName + end;
        input = new ArrayList<String>();
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

    public String getOutputFromLine(int number) {
        number--;
        if (number < 0) {
            return input.get(0);
        } else
            return input.get(number);
    }


}