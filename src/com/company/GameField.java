package com.company;

import java.util.Random;

public class GameField {
    public static int SCREEN_HEIGHT = 20;
    public static int SCREEN_WIDTH = 20;

    Cell[][] gameScreen = new Cell[SCREEN_HEIGHT][SCREEN_WIDTH];

    public GameField() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);
                Random r =  new Random();
boolean isCellAlive = r.nextBoolean();
          gameScreen[i][j] = new Cell(i,j,isCellAlive);
            }
        }
    }

    void print(){
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {

              Cell current = gameScreen[i][j];
                System.out.print(" "+current.getPrintableChar());

            }
            System.out.println();
            
        }
    }
    
    
}
