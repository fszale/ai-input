package com.ai.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InputFromKeyboard extends Thread implements InputFeed {

    private ArrayList<InputEvent> eventQueue;

    public InputFromKeyboard(ArrayList<InputEvent> eq) {
        this.eventQueue = eq;
    }

    public void run() {

        do {
            String command = readInputLine("Say something...\n\r");
            InputEvent ev = new InputEvent();
            ev.name = command;
            eventQueue.add(ev);
        }
        while (true);

    }

    public String trace() {
        String ret = "";

        return ret;
    }

    public String status() {
        String ret = "";

        return ret;
    }

    public static String readInputLine(String prompt) {

        String inString = "";
        try {
            // create buffered reader instance
            BufferedReader ibr = new BufferedReader(new InputStreamReader(System.in));
            while (inString.equals("")) {
                System.out.print(prompt);
                inString = ibr.readLine().trim();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return inString;
    }

}
