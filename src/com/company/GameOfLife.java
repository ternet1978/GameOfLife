package com.company;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameOfLife {

    public static void main(String[] args) throws UnknownHostException {
	// write your code here
//        System.out.println("Hello world!");
//        String hostAddress = InetAddress.getLocalHost().getHostAddress();
//        System.out.println(hostAddress);
        GameField g = new GameField();
        g.print();
    }
}
