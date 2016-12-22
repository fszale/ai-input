package com.ai.input;// todo add input classes for nlp, speech to text conversion, vision, hearing, taste, smell, touch, intuition

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.*;

public class InputFactory {

    public static ArrayList<InputEvent> eventQueue = new ArrayList<InputEvent>();
    private static ArrayList<Thread> threads = new ArrayList<Thread>();

    public static void init() {

        // run the keyboard input on a thread
        Thread t = new InputFromKeyboard(eventQueue);
        threads.add(t);
        t.start();
    }

    public static void run() {

        for (int i=0;i<threads.size();i++){
            try {
                threads.get(i).sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("thread interrupted\n\r");
            }
        }

    }

    public static void status() {

        for (int i=0;i<threads.size();i++){
            Thread t = threads.get(i);
            System.out.println("Thread " + ((InputFeed)t).status());
        }

    }

    public static void trace() {

        for (int i=0;i<threads.size();i++){
            Thread t = threads.get(i);
            System.out.println("Thread " + ((InputFeed)t).trace());
        }

    }
}
