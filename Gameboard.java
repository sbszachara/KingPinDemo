/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Steven Szachara
 */
public class Gameboard {
    int plantations;
    int organizer;
    int middleman;
    int enforcer;
    
    public Gameboard(){
        plantations = 5;
        organizer = 1;
        middleman = 1;
        enforcer = 6;
    }
    
    public void setPlantations(int plant){
        plantations = plant;
    }
    
    public void addPlantations (int addd){
        plantations = plantations + addd;
    }
    
    public void destroyPlantations (int dest){
        if (dest > plantations)
        { 
            System.out.println("There are no more plantations.");
            plantations = 0;
        }
        else
        {
        plantations = plantations - dest;
        }
    }
    
    public int getPlantations (){
        return plantations;
    }
    
    
    
    
    public void setOrg(int org){
        organizer = org;
    }
    
    public void addOrg (int org){
        organizer = organizer + org;
    }
    
    public void destroyOrg (int dest){
        organizer = organizer - dest;
    }
    
    public int getOrg (){
        return organizer;
    }
    
    
    
    
    public void setMid(int mid){
        middleman = mid;
    }
    
    public void addMid(int mid){
        middleman = middleman + mid;
    }
    
    public void destroyMid(int dest){
        middleman = middleman - dest;
    }
    
    public int getMid(){
        return middleman;
    }
    
    
    public void setEnf(int enf){
        enforcer = enf;
    }
    
    public void addEnf(int enf){
        enforcer = enforcer + enf;
    }
    
    public int destroyEnf(int enf){
        if (enforcer == 0)
        {
            enforcer = 0;
            return 0;
        }
        else if (enforcer == 1 && enf == 1)
        {
            enforcer = 0;
            return 1;
        }
        else if (enforcer == 1 && enf == 2)
        {
            enforcer = 0;
            return 1;
        }
        else if (enforcer >= 2 && enf == 1)
        {
            enforcer = enforcer - enf;
            return 1;
        }
        else
        {
            enforcer = enforcer - enf;
            return enf;
        }
    }
    
    public void subtractEnf(int enf){
        enforcer = enforcer - enf;
    }
    
    public int getEnf(){
        return enforcer;
    }
    
    public static void showGameBoard(Player player) throws InterruptedException {
        System.out.println("This is what your gameboard looks like:");
        System.out.println("|------------------------------------------------|");
        System.out.println("| GAMEBOARD                                      |");
        System.out.println("|------------------------------------------------|");
        System.out.println(Player.moneyPrint(player));
        System.out.println(Player.printPlant(player));
        System.out.println(Player.printInv(player));
        System.out.println(Player.printOrg(player));
        System.out.println(Player.printMid(player));
        System.out.println(Player.printEnf(player));
        System.out.println("|------------------------------------------------|");
        Thread.sleep(6000);
    }
    
    
    
}
