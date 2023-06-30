import fileInput.FileInput;
import readingSession.FullReadingSession;
import readingSession.SingleReadingSession;

import java.io.*;

public class Main {

    // ignore first 12 lines!!!!!
    public static void main(String[] args) throws FileNotFoundException {

        FileInput input = new FileInput("Moscow");

        FullReadingSession FULL = new FullReadingSession(input);

        SingleReadingSession SINGLE;

        for(int i = 0; i < input.getCounter(); i++){
            SINGLE = FULL.getSingleSession(i);
            System.out.println(SINGLE);
        }
    }
}


