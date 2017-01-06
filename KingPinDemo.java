/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.InputMismatchException;
import java.util.Random;
//import static kingpin.demo.KingPinDemo.player1;

public class KingPinDemo{
    static int currentPlayer = 0;
    static Player player1 = new Player();
    static Player player2 = new Player();
    static Player player3 = new Player();
    static Player player4 = new Player();
    
    
    public static void main(String[] args) throws InterruptedException,InputMismatchException {
        
    currentPlayer = 1;
    Turn.startTurn();
    System.out.println("|------------------------------------------------|");
    System.out.println("|                                                |");
    System.out.println("|   THATS ALL FOR NOW, JUST A PROOF OF CONCEPT   |");
    System.out.println("|                                                |");
    System.out.println("|------------------------------------------------|");
    Thread.sleep(2000);
    System.out.println("|------------------------------------------------|");
    System.out.println("|                                                |");
    System.out.println("|     THANKS FOR PLAYING THE KINGPIN DEMO!       |");
    System.out.println("|                                                |");
    System.out.println("|------------------------------------------------|");
    }
    
    
    
    
    
    

    
    public static Player currentPlayer(){
        switch (currentPlayer) {
            case 1:
                return player1;
            case 2:
                return player2;
            case 3:
                return player3;
            default:
                return player4;
        }
    }
    
    
}
