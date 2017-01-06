/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;


public class Player extends KingPinDemo{
    
    int money;
    //0 is dead 1 is alive
    int alive;
    //0 is nothing, 1 is hit, 2 is Upgrade
    int inventory;
    Gameboard gameboard = new Gameboard();
    Hand hand = new Hand();
    
    public Player(){
        money = 1000000;
        alive = 1;
        inventory = 0;
    }
    
    
    public boolean inventoryFull(){
        if (inventory == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    
    
    public void setMoney(int mon){
        money = mon;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void addMoney(int mon){
        money = money + mon;
    }
    
    public void subtractMoney(int mon){
        if (mon > money){
            money = 0;
        }
        else{
            money = money - mon;
        }
    }
    
    public void setAlive(int aliv)
    {
        alive = aliv;
    }
    
    public int getAlive(){
        return alive;
    }
    
    public void setInventory(int inv){
        inventory = inv;
    }
    
    public int getInventory()
    {
        return inventory;
    }
    
    public static void addIncome(Player player){
        player.money = player.money + (player.gameboard.plantations*100000);
        player.money = player.money + (player.gameboard.enforcer*10000);
        player.money = player.money + (player.gameboard.middleman*30000);
        player.money = player.money + (player.gameboard.organizer*80000);
    }
    
    public static boolean canDoHit(Player player){
        if (player.gameboard.getEnf() < 2)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static boolean buyHit(Player player){
        if (player.money >= 750000 && player.inventoryFull() == false)
        {
            player.money = player.money - 750000;
            player.inventory = 1;
            System.out.println("You have bought a Hit.");
            return true;
        }
        else
        {
            if (player.inventoryFull() == true)
            {
                System.out.println("You already have something in your inventory.");
                System.out.println("You can only have one item in your inventory at a time.");
            }
            else
            {
                System.out.println("You do not have enough money to buy a Hit. Required: $750,000.");
            }
            return false;
        }
    }
    
    public static boolean buyUpgrade(Player player){
        if (player.money >= 250000 && player.inventoryFull() == false)
        {
            player.money = player.money - 250000;
            player.inventory = 2;
            System.out.println("You have bought an Upgrade.");
            return true;
        }
        else
        {
            if (player.inventoryFull() == true)
            {
                System.out.println("You already have something in your inventory.");
                System.out.println("You can only have one item in your inventory at a time.");
            }
            else
            {
                System.out.println("You do not have enough money to buy an Upgrade. Required: $250,000.");
            }
            return false;
        }
    }
    
    public static boolean buyPlant(Player player){
        if (player.money >= 500000 && player.inventoryFull() == false)
        {
            player.money = player.money - 500000;
            player.gameboard.addPlantations(1);
            System.out.println("You have bought a Plantation.");
            return true;
        }
        else
        {
            if (player.inventoryFull() == true)
            {
                System.out.println("You already have something in your inventory.");
                System.out.println("You can only have one item in your inventory at a time.");
            }
            else
            {
                System.out.println("You do not have enough money to buy an upgrade. Required: $500,000.");
            }
            return false;
        }
    }
    
    public static boolean buyEnf(Player player){
        if (player.money >= 150000 && player.inventoryFull() == false)
        {
            player.money = player.money - 150000;
            player.gameboard.addEnf(1);
            System.out.println("You have bought an Enforcer.");
            return true;
        }
        else
        {
            if (player.inventoryFull() == true)
            {
                System.out.println("You already have something in your inventory.");
                System.out.println("You can only have one item in your inventory at a time.");
            }
            else
            {
                System.out.println("You do not have enough money to buy an Enforcer. Required: $150,000.");
            }
            return false;
        }
    }
    
    
    
    
    public static String printPlant(Player player){
        if (player.gameboard.plantations >= 10)
        {
            return "| Plantations: " + player.gameboard.plantations + "                                |";
        }
        else
        {
            return "| Plantations: " + player.gameboard.plantations + "                                 |";
        }
    }
    
     public static String printEnf(Player player){
        if (player.gameboard.enforcer >= 10)
        {
            return "| Enforcers: " + player.gameboard.enforcer + "                                  |";
        }
        else
        {
            return "| Enforcers: " + player.gameboard.enforcer + "                                   |";
        }
    }
     
     public static String printMid(Player player){
        if (player.gameboard.middleman >= 10)
        {
            return "| Middlemen: " + player.gameboard.middleman + "                                  |";
        }
        else
        {
            return "| Middlemen: " + player.gameboard.middleman + "                                   |";
        }
    }
     
     public static String printOrg(Player player){
        if (player.gameboard.organizer >= 10)
        {
            return "| Organizers: " + player.gameboard.organizer + "                                 |";
        }
        else
        {
            return "| Organizers: " + player.gameboard.organizer + "                                  |";
        }
    }
    
    
    
    
    public static String printInv(Player player){
        if (player.inventory == 2)
        {
           return "| Inventory: Upgrade Available.                  |";
        }
        else if (player.inventory == 1)
        {
           return "| Inventory: Hit Available.                      |";
        }
        else
        {
           return "| Inventory: Empty.                              |";
        }
    }
    
    public static String moneyPrint(Player player){
        if (player.getMoney() >= 10000000)
        {
            return "| Money: "+ player.getMoney() +"                                |";
        }
        else if (player.getMoney() >= 1000000)
        {
            return "| Money: "+ player.getMoney() +"                                 |";
        }
        else if (player.getMoney() >= 100000)
        {
            return "| Money: "+ player.getMoney() +"                                  |";
        }
        else if (player.getMoney() >= 10000)
        {
            return "| Money: "+ player.getMoney() +"                                   |";
        }
        else if (player.getMoney() >= 1000)
        {
            return "| Money: "+ player.getMoney() +"                                    |";
        }
        else if (player.getMoney() >= 100)
        {
            return "| Money: "+ player.getMoney() +"                                     |";
        }
        else if (player.getMoney() >= 10)
        {
            return "| Money: "+ player.getMoney() +"                                      |";
        }
        else
        {
            return "| Money: "+ player.getMoney() +"                                       |";
        }
            
    }
    
    
    
    public static void drawCard() throws InterruptedException{
    Random rand = new Random();
    int cardDrawn = rand.nextInt(6) + 1;
    Card card1 = new Card();
    Card card2 = new Card();
    Card card3 = new Card();
    Card card4 = new Card();
    Card card5 = new Card();
    Card card6 = new Card();
    
    if(currentPlayer().hand.full == false)
    {
        System.out.println("You end your turn and draw a card.");
        Thread.sleep(5000);
    if (cardDrawn == 1)
    {
        card1 = new Card("New Card", "nothing", 2, 1);
        card1.setInfo("You've found a more efficient trade route.    ");
        card1.randomValue();
        card1.setEffectInfo("Gain " + card1.getValue() + 
                        " dollars this turn.         ");
        currentPlayer().hand.card = card1;
        currentPlayer().hand.full = true;
    }
    
    else if (cardDrawn == 2)
    {
        card2 = new Card("New Card", "nothing", 2, 2);
        card2.setInfo("You found new land to set up plantations.     ");
        card2.randomValue();
        card2.setEffectInfo("Gain " + card2.getValue() + 
                        " plantation(s) this turn.       ");
        currentPlayer().hand.card = card2;
        currentPlayer().hand.full = true;
    }
    
    else if (cardDrawn == 3)
    {
        card3 = new Card("New Card", "nothing", 2, 3);
        card3.setInfo("Your cartel is gaining popularity.            ");
        card3.randomValue();
        card3.setEffectInfo("Gain 1 enforcer this turn.            ");
        currentPlayer().hand.card = card3;
        currentPlayer().hand.full = true;
    
    }
    
    else if (cardDrawn == 4)
    {
       card4 = new Card("New Card", "nothing", 1, 3);
       card4.setInfo("You found a meeting place of an enemy cartel. ");
       card4.randomValue();
       card4.setEffectInfo("Kill an enemy enforcer this turn.     ");
       currentPlayer().hand.card = card4;
       currentPlayer().hand.full = true;
    
    }
    else if (cardDrawn == 5)
    {
        card5 = new Card("New Card", "nothing", 1, 2);
        card5.setInfo("You've ambushed an enemy cartel's land.       ");
        card5.randomValue();
        card5.setEffectInfo("Steal " + card5.getValue() + " plantation(s) from an enemy.  ");
        currentPlayer().hand.card = card5;
        currentPlayer().hand.full = true;
    }
    else {
        
        card6 = new Card("New Card", "nothing", 1, 1);
        card6.setInfo("You've taken over an enemey trade route.      ");
        card6.randomValue();
        card6.setEffectInfo("Steal " + card6.getValue() + " dollars from an enemy.    ");
        currentPlayer().hand.card = card6;
        currentPlayer().hand.full = true;
    }
    }
    
    else
    {
        System.out.println("You end your turn but already have a card in hand, and do not draw another.");
        Thread.sleep(5000);
    }
    
    }
    
    
    
    
    
    
    
    
}
