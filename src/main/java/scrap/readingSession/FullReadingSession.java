package scrap.readingSession;

import scrap.fileInput.FileInput;

import java.util.ArrayList;
import java.util.List;
/*
public class FullReadingSession {

    List<SingleReadingSession> list;

    public FullReadingSession() {
        list = new ArrayList<>();
    }

    public FullReadingSession(FileInput fileInput) {
        list = new ArrayList<>();
        initializeFromFileInput(fileInput);
    }

    public void addReadingSession(SingleReadingSession singleReadingSession) {
        list.add(singleReadingSession);
    }

    private void initializeFromFileInput(FileInput fileInput) {
        for (int i = 0; i < fileInput.getLength(); i++) {
            String line = fileInput.getSingleLine(i);
            if (!(line.isEmpty() || line.trim().equals("") || line.trim().equals("\n"))) {
                addReadingSession(new SingleReadingSession(line));
            }
        }
    }

    public SingleReadingSession getSingleSession(int number) {
        return list.get(number);
    }
}


 */