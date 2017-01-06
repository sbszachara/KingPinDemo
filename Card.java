/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Steven Szachara
 */
public class Card extends KingPinDemo{
    String info;
    String effectInfo;
    //0 is nothing, 1 is intimidation, 2 is ambition
    int type;
    //0 is nothing, 1-6 is certain effects
    int effect;
    
    int value;
    
    public Card() {
        info = "New Card";
        effectInfo = "nothing";
        type = 0;
        effect = 0;
        value = 0;
    }
    
    public Card (String inf, String effinf, int typ, int eff){
        Random rand = new Random();
        info = inf;
        effectInfo = effinf;
        type = typ;
        effect = eff;
    }
    
    public String getEffectInfo(){
        return effectInfo;
    }
    
    public void setEffectInfo(String effinf){
        effectInfo = effinf;
    }
    
    public String getInfo()
    {
        return info;
    }
    
    public int getType(){
        return type;
    }
    
    public int getEffect(){
        return effect;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setInfo(String inf){
        info = inf;
    }
    
    public void setTypeAmbition(){
        type = 1;
    }
    
    public void setTypeIntimidation(){
        type = 2;
    }
    
    public void setEffect(int eff){
        effect = eff;
    }
    
    
    
    
    
    
    
    
    
    public void randomValue(){
        Random rand = new Random();
        if (effect == 1){
           value = (rand.nextInt(9) + 1)*10000;
        }
        if (effect == 2){
                value = rand.nextInt(3) + 1;
        }
        if (effect == 3){
                value = 1;
        } 
    }
    
    
    
    
    
    
    
    
    public void showCard() throws InterruptedException{
        System.out.println("This is your card in hand:");
        System.out.println("|------------------------------------------------|");
        System.out.println("| CARD INFO                                      |");
        System.out.println("|------------------------------------------------|");
        System.out.println("| " + info + " |");
        System.out.println("| EFFECT: " + effectInfo + " |");
        System.out.println("|------------------------------------------------|");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Thread.sleep(6000);
    }
    
    
    
    
    
    
    
    
    
    
    
    public void actionCard(Player player){
        if (type == 2){
            if (effect == 1){
               player.addMoney(value);
            }
            else if (effect == 2){
                player.gameboard.addPlantations(value);
            }
            else{
                player.gameboard.addEnf(value);
            }
        }
        else
        {
            if (effect == 1)
            {
                player.subtractMoney(value);
                currentPlayer().addMoney(value);
            }
            else if (effect == 2)
            {
                player.gameboard.destroyPlantations(value);
                currentPlayer().gameboard.addPlantations(value);
            }
            else
            {
                player.gameboard.destroyEnf(value);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    public void playCard() throws InputMismatchException{
        int choice = 0;
        if (type == 2){
            if (currentPlayer == 1)
            {
                choice = 1;
            }
            else if (currentPlayer == 2)
            {
                 choice = 2;
            }
            else if (currentPlayer == 3)
            {
                choice = 3;
            }
            else
            {
                choice = 4;
            }
        }
        else
        {  
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            if (currentPlayer == 1)
            {  
                do {
                    try {
                        System.out.println("Player selection:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| PLAY CARD ON PLAYER                            |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [2]: Player 2                                  |");
                        System.out.println("| [3]: Player 3                                  |");
                        System.out.println("| [4]: Player 4                                  |");
                        System.out.println("|------------------------------------------------|");
                        choice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
                    } while (choice != 2 && choice != 3 && choice != 4);
            }
            else if (currentPlayer == 2)
            {
                do {
                    try {
                        System.out.println("Player selection:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| PLAY CARD ON PLAYER                            |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [1]: Player 1                                  |");
                        System.out.println("| [3]: Player 3                                  |");
                        System.out.println("| [4]: Player 4                                  |");
                        System.out.println("|------------------------------------------------|");
                        choice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
                    } while (choice != 1 && choice != 3 && choice != 4);
                
            }
            else if (currentPlayer == 3)
            {
                do {
                    try {
                        System.out.println("Player selection:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| PLAY CARD ON PLAYER                            |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [1]: Player 1                                  |");
                        System.out.println("| [2]: Player 2                                  |");
                        System.out.println("| [4]: Player 4                                  |");
                        System.out.println("|------------------------------------------------|");
                        choice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
                    } while (choice != 1 && choice != 2 && choice != 4);
            }
            else
            {
                do {
                    try {
                        System.out.println("Player selection:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| PLAY CARD ON PLAYER                            |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [1]: Player 1                                  |");
                        System.out.println("| [2]: Player 2                                  |");
                        System.out.println("| [3]: Player 3                                  |");
                        System.out.println("|------------------------------------------------|");
                        choice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
                    } while (choice != 1 && choice != 2 && choice != 3);
            }
            
        }
        if (choice == 1)
        {
            actionCard(player1);
            System.out.println("You have played your card on Player 1.");
            Hand.emptyHand();
        }
        else if (choice == 2)
        {
            actionCard(player2);
            System.out.println("You have played your card on Player 2.");
            Hand.emptyHand();
        }
        else if (choice == 3)
        {
            actionCard(player3);
            System.out.println("You have played your card on Player 3.");
            Hand.emptyHand();
        }
        else
        {
            actionCard(player4);
            System.out.println("You have played your card on Player 4.");
            Hand.emptyHand();
        }
        
    }
    
    
}
   
