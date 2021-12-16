package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class GameField {
    public static int SCREEN_HEIGHT = 4;
    public static int SCREEN_WIDTH = 5;

    Cell[][] gameScreen = new Cell[SCREEN_HEIGHT][SCREEN_WIDTH];
    Cell[][] gameScreenTemp = new Cell[SCREEN_HEIGHT][SCREEN_WIDTH];

    public GameField() {
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
//                System.out.println("i = " + i);
//                System.out.println("j = " + j);
                Random r =  new Random();
boolean isCellAlive = r.nextBoolean();
             //   System.out.println(isCellAlive);
          gameScreen[i][j] = new Cell(i,j,isCellAlive);
                gameScreenTemp[i][j] = new Cell(i,j,isCellAlive);
            }
        }
    }
    void simulateNextStep(){
        // для каждой ячейки

        // если клетка мертва и соседей 3, то оживить
        // если клетка жива и соседей 2/3 то жить
        // иначе убить клетку
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                Cell current = gameScreen[i][j];
                Cell currentTemp = gameScreenTemp[i][j];
                // посчитать кол живых соседей
                long aliveNeighbours = calculateNeighbours(current,gameScreen);
                // если клетка мертва и соседей 3, то оживить
                // если клетка жива и соседей 2/3 то жить
                // иначе убить клетку
                if (!current.alive && aliveNeighbours == 3) {currentTemp.alive=true;}
                else if (current.alive==true && (aliveNeighbours == 3 || aliveNeighbours == 2  ) ) {currentTemp.alive=true;}
                else currentTemp.alive =false;


            }
        }

        //восстанавливаем массив копированием
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {
                gameScreen[i][j].alive = gameScreenTemp[i][j].alive;
            }
        }
       // gameScreen = Arrays.copyOf(gameScreenTemp, gameScreenTemp.length);
    }

    private long calculateNeighbours(Cell cell, Cell[][] gameScreen) {
int x = cell.x;
int y = cell.y;

// a    b   c
// d  cell  e
// f    g   h

var a = getCellByCoords(x-1,y-1,gameScreen);
var b = getCellByCoords(x,y-1,gameScreen);
var c = getCellByCoords(x+1,y-1,gameScreen);

var d = getCellByCoords(x-1,y,gameScreen);
var e = getCellByCoords(x+1,y,gameScreen);

var f = getCellByCoords(x-1,y+1,gameScreen);
var g = getCellByCoords(x,y+1,gameScreen);
var h = getCellByCoords(x+1,y+1,gameScreen);
return Stream.of(a,b,c,d,e,f,g,h)
        .filter(ccell -> ccell !=null)  .filter(ccell -> ccell.alive)
        .count();
//


    }

    private boolean isAliveCell(int x, int y, Cell[][] gameScreen)  throws NullPointerException{
        if (x<0 || y<0) return false;
        if (x>SCREEN_WIDTH || y>SCREEN_HEIGHT) return false;
        return gameScreen[x][y].alive;
    }

    private Cell getCellByCoords(int x, int y, Cell[][] gameScreen)throws NullPointerException{
        if (x<0 || y<0) return null;
        if (x>=SCREEN_WIDTH || y>=SCREEN_HEIGHT) return null;
        return gameScreen[y][x];
    }




    void print(){
        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            for (int j = 0; j < SCREEN_WIDTH; j++) {

              Cell current = gameScreen[i][j];
                System.out.print(" "+current.getPrintableChar());

            }
            System.out.println();
            
        }
      //  CLS
     System.out.println();
      System.out.println("_______________________");
       System.out.println();
    }
    
    
}
