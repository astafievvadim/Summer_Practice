import FileInput.FileInput;

import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        int ignoredLines = 12;
        FileInput input = new FileInput("Moscow");
        int number = 1 + ignoredLines;
        String a = input.getOutputFromLine(number);

        System.out.println(a);
    }
}


