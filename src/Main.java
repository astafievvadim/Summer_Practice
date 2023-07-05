import time.TimeWindow;

import java.io.*;
import java.sql.Time;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParseException {

        String start = "2023-07-04 23:48:05";
        String end = "2023-07-04 23:50:27";

        TimeWindow aboba = new TimeWindow(start, end, 1);


        System.out.println(aboba.getStart().toString());
        System.out.println(aboba.getTimeInterval());
        System.out.println(aboba.getEnd().toString());
    }
}

/*
        FileInput input = new FileInput("shoot.json");

        //FullReadingSession FULL = new FullReadingSession(input);

        SingleReadingSession SINGLE;

        System.out.println(input.getSingleLine(1));

        for(int i = 0; i < input.getLength(); i++){
            SINGLE = FULL.getSingleSession(i);
            System.out.println(SINGLE);
        }



        for(int i = 0; i < input.getLength(); i++){
            String singleLine = input.getSingleLine(i);
            System.out.println(singleLine);
        }

*/
