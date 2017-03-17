/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astrominer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 *
 * @author Thomas
 */
public class InputHandler implements Runnable {
    
    static Thread thread;
    Scanner inputScanner = new Scanner(System.in);
    Queue<String> inputList = new ConcurrentLinkedDeque<>();
    
    public void start(){
        if (thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }
    
    public boolean hasInput(){
        return !inputList.isEmpty();
    }
    
    public String getInput(){
        return inputList.poll();
    }
    
    @Override
    public void run(){
        System.out.println("Inputhandler now handling input");
        while (true){
            String input = inputScanner.nextLine();
            inputList.add(input);
            System.out.println("Received " + input + " [" + Integer.toString(inputList.size()) + "]");
        }
    }
}
