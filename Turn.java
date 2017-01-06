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
public class Turn extends KingPinDemo{
    
    static boolean hasBought = false;
    static boolean hasPlayed = false;
    
    public static void startTurn() throws InterruptedException{
        int counter = 0;
        while (counter != 8)
        {
        System.out.println("|------------------------------------------------|");
        System.out.println("|                                                |");
        System.out.println("| STARTING TURN FOR PLAYER " + currentPlayer + "                     |");
        System.out.println("|                                                |");
        System.out.println("|------------------------------------------------|");
        Thread.sleep(8000);
        Player.addIncome(currentPlayer());
        turnMenu(currentPlayer());
        counter = counter + 1;
        }
        
    }
    
    public static void turnMenu(Player player) throws InterruptedException{
        int choice = 0;
        Scanner reader = new Scanner(System.in); 
        do {
                    try {
                        System.out.println("Turn:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| TURN MENU                                      |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [1]: Show Gameboard                            |");
                        System.out.println("| [2]: Show Card                                 |");
                        System.out.println("| [3]: Play Card                                 |");
                        System.out.println("| [4]: Play Item in Inventory                    |");
                        System.out.println("| [5]: Buy Menu                                  |");
                        System.out.println("| [6]: End Turn                                  |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("");
                        choice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
            } while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6);
        if (choice == 1)
        {
            Gameboard.showGameBoard(player);
            turnMenu(player);
        }
        else if (choice == 2)
        {
            if (player.hand.full == true)
            {
                player.hand.card.showCard();
                turnMenu(player);
            }
            else
            {
                System.out.println("You do not have a card in your hand.");
                Thread.sleep(3000);
                turnMenu(player);
            }
        }
        
        else if (choice == 3)
        {
            if (player.hand.full == true)
            {
                player.hand.card.playCard();
                Thread.sleep(3000);
                turnMenu(player);
            }
            else
            {
                System.out.println("You do not have a card in your hand.");
                Thread.sleep(3000);
                turnMenu(player);
            }
        }
        
        
        
        else if (choice == 4)
        {
            if(player.inventoryFull() == true && hasBought == false)
            {
                playInventory(player);
                turnMenu(player);
            }
            
            else if (hasBought == true)
            {
                System.out.println("You have already bought something.");
                System.out.println("You must wait till next turn in order to play an item.");
                Thread.sleep(4000);
                turnMenu(player);
            }
            
            else if (player.inventoryFull() == false)
            {
                System.out.println("You don't have anything in your inventory to play.");
                Thread.sleep(3000);
                turnMenu(player);
            }
        }
        else if (choice == 5)
        {
            if(hasBought == false && hasPlayed == false)
            {
                buyMenu(player);
                turnMenu(player);
            }
            else if (hasPlayed == true)
            {
                System.out.println("You have already played an item this turn.");
                System.out.println("You can only buy or play an item per turn.");
                Thread.sleep(3000);
                turnMenu(player);
            }
            else
            {
                System.out.println("You have already bought something this turn.");
                System.out.println("You can only buy once per turn.");
                Thread.sleep(3000);
                turnMenu(player);
            }
        }
        else
        {
            int endChoice = 0;
            do {
                    try {
                        System.out.println("End Turn:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| ARE YOU SURE?                                  |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [1]: Yes                                       |");
                        System.out.println("| [2]: No                                        |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("");
                        endChoice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
            } while (endChoice != 1 && endChoice != 2);
            if(endChoice == 1)
            {
                hasBought = false;
                hasPlayed = false;
                player.drawCard();
                if (KingPinDemo.currentPlayer == 4)
                {
                    KingPinDemo.currentPlayer = 1;
                }
                else
                {
                    KingPinDemo.currentPlayer = KingPinDemo.currentPlayer + 1;
                }
            }
            else
            {
                turnMenu(player);
            }
        }
    }
    

    
    
    
    
    
    
    public static void playInventory(Player player) throws InterruptedException{
        int choice = 0;
        Scanner reader = new Scanner(System.in);
        if (player.inventory == 1)
        {
            do {
                    try {
                        System.out.println("You have a hit available:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| HIT MENU                                       |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [1]: Conduct Hit                               |");
                        System.out.println("| [2]: Return to TURN MENU                       |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("");
                        choice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
                } while (choice != 1 && choice != 2);
            
            if (choice == 1)
            {
                if(player.gameboard.enforcer >= 1)
                {
                   conductHit(player);
                   hasPlayed = true;
                }
                else
                {
                    System.out.println("You do not have enough enforcers to conduct a hit. Required: 1");
                    Thread.sleep(2000);
                    System.out.println("Returning to TURN MENU.");
                    Thread.sleep(2000);
                }
            }
            else
            {
                System.out.println("Returning to TURN MENU.");
                Thread.sleep(2000);
            }   
        }
        
        
        
        else
        {
            do {
                    try {
                        System.out.println("You have an upgrade available:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| UPGRADE MENU                                   |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [1]: Upgrade Enforcers to Middleman            |");
                        System.out.println("| [2]: Upgrade Middleman to Organizer            |");
                        System.out.println("| [3]: Return to TURN MENU                       |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("");
                        choice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
                } while (choice != 1 && choice != 2 && choice != 3);
            
            if(choice == 1)
            {
                if(player.gameboard.enforcer >= 2)
                {
                    player.gameboard.subtractEnf(2);
                    player.gameboard.addMid(1);
                    System.out.println("You have upgraded two Enforcers to a Middleman.");
                    player.inventory = 0;
                    hasPlayed = true;
                    Thread.sleep(3000);
                }
                else
                {
                    System.out.println("You do not have enough Enforcers to upgrade to a Middleman. Required: 2");
                    System.out.println("Returning to TURN MENU.");
                    Thread.sleep(3000);
                }
            }
            else if (choice == 2)
            {
                if(player.gameboard.middleman >= 2)
                {
                    player.gameboard.destroyMid(2);
                    player.gameboard.addOrg(1);
                    System.out.println("You have upgraded two Middlemen to an Organizer.");
                    player.inventory = 0;
                    hasPlayed = true;
                    Thread.sleep(3000);
                }
                else
                {
                    System.out.println("You do not have enough Middlemen to upgrade to an Organizer. Required: 2");
                    System.out.println("Returning to TURN MENU.");
                    Thread.sleep(3000);
                }
            }
            else
            {
                System.out.println("Returning to TURN MENU.");
                    Thread.sleep(3000);
            }
        }
    }
    
    public static void conductHit(Player player) throws InterruptedException{
        int choice = 0;
        Scanner reader = new Scanner(System.in);
        if (currentPlayer == 1)
            {  
                do {
                    try {
                        System.out.println("Player selection:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| CONDUCT HIT ON PLAYER                          |");
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
                        System.out.println("| CONDUCT HIT ON PLAYER                          |");
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
                        System.out.println("| CONDUCT HIT ON PLAYER                          |");
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
                        System.out.println("| CONDUCT HIT ON PLAYER                          |");
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
            
        if (choice == 1)
        {
            if (player1.gameboard.enforcer >= 1)
            {
            System.out.println("You have placed a hit on Player 1.");
            Thread.sleep(3000);
            hitHappens(player1);
            player.inventory = 0;
            }
            else
            {
                System.out.println("That player has no enforcers to kill!");
                Thread.sleep(3000);
                playInventory(player);
            }
        }
        else if (choice == 2)
        {
            if (player2.gameboard.enforcer >= 1)
            {
            System.out.println("You have placed a hit on Player 2.");
            Thread.sleep(3000);
            hitHappens(player2);
            player.inventory = 0;
            }
            else
            {
                System.out.println("That player has no enforcers to kill!");
                Thread.sleep(3000);
                playInventory(player);
            }
            
        }
        else if (choice == 3)
        {
            if (player3.gameboard.enforcer >= 1)
            {
            System.out.println("You have placed a hit on Player 3.");
            Thread.sleep(3000);
            hitHappens(player3);
            player.inventory = 0;
            }
            else
            {
                System.out.println("That player has no enforcers to kill!");
                Thread.sleep(3000);
                playInventory(player);
            }
        }
        else
        {
            if (player4.gameboard.enforcer >= 1)
            {
            System.out.println("You have placed a hit on Player 4.");
            Thread.sleep(3000);
            hitHappens(player4);
            player.inventory = 0;
            }
            else
            {
                System.out.println("That player has no enforcers to kill!");
                Thread.sleep(3000);
                playInventory(player);
            }
        }
    }
    
    //in this case player is the player getting hurt
    public static void hitHappens(Player player) throws InterruptedException{
        Random rand = new Random();
        int diceCurrent = rand.nextInt(6) + 1;
        int dicePlayer = rand.nextInt(6) + 1;
        System.out.println("You both roll a dice.");
        Thread.sleep(3000);
        System.out.println("You roll a: " + diceCurrent);
        Thread.sleep(2000);
        System.out.println("They roll a: " + dicePlayer);
        Thread.sleep(2000);
        
        
        if(diceCurrent > dicePlayer)
        {
            int whatHappened = player.gameboard.destroyEnf(2);
            if (whatHappened == 2)
            {
                System.out.println("You have killed two enemy enforcers!");
            }
            else
            {
                System.out.println("You have killed one enemy enforcer!");
            }
            Thread.sleep(3000);
        }
        else if (diceCurrent == dicePlayer)
        {
            player.gameboard.destroyEnf(1);
            System.out.println("You have killed one enemy enforcer!");
            Thread.sleep(3000);
        }
        else
        {
            player.gameboard.destroyEnf(1);
            currentPlayer().gameboard.destroyEnf(1);
            System.out.println("You and the enemy loose one enforcer!");
            Thread.sleep(3000);
        }
        
        
    }
    
    
    
    
    public static void buyMenu(Player player) throws InputMismatchException, InterruptedException{
        int choice = 0;
        Scanner reader = new Scanner(System.in); 
        //Just the visual
        do {
                    try {
                        System.out.println("Choose what to buy:");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| BUY MENU                                       |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("| [1]: Plantation                                |");
                        System.out.println("| [2]: Enforcer                                  |");
                        System.out.println("| [3]: Hit                                       |");
                        System.out.println("| [4]: Upgrade                                   |");
                        System.out.println("| [5]: Go Back                                   |");
                        System.out.println("|------------------------------------------------|");
                        System.out.println("");
                        choice = reader.nextInt();
                        } catch (InputMismatchException e) {
                        }
                        reader.nextLine(); // clears the buffer
            } while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);
        
        
        if(choice == 1)
        {
            if(Player.buyPlant(player) == true)
            {
              hasBought = true;
              Thread.sleep(3000);
            }
            else
            {
                Thread.sleep(3000);
                buyMenu(player);
            }
        }
        else if (choice == 2)
        {
            if(Player.buyEnf(player) == true)
            {
                hasBought = true;
                Thread.sleep(3000);
            }
            else
            {
                Thread.sleep(3000);
                buyMenu(player);
                
            }
            
        }
        else if (choice == 3)
        {
            if(Player.buyHit(player) == true)
            {
              hasBought = true;
              Thread.sleep(3000);
            }
            else
            {
                Thread.sleep(3000);
                buyMenu(player);
            }
        }
        else if (choice == 4)
        {
            if(Player.buyUpgrade(player) == true)
            {
              hasBought = true;
              Thread.sleep(3000);
            }
            else
            {
                Thread.sleep(3000);
                buyMenu(player);
            }
        }
        
        else
        {
            hasBought = false;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
