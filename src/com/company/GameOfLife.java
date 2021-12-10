package com.company;

import java.net.UnknownHostException;

public class GameOfLife {

    public static void main(String[] args) throws UnknownHostException, InterruptedException {
	// write your code here
//        System.out.println("Hello world!");
//        String hostAddress = InetAddress.getLocalHost().getHostAddress();
//        System.out.println(hostAddress);
        GameField g = new GameField();
       while (true) {
           g.simulateNextStep();

           g.print();
           Thread.sleep(500);
       }
    }



}
