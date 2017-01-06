/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Steven Szachara
 */
public class Hand extends KingPinDemo{
    Card card = new Card();
   
    //0 is empty, 1 is full
    Boolean full;
    
    public Hand() {
        card = null; 
        full = false;
    }
    
    public Card getCard(){
        return card;
    }
    
    public void setCard (Card card1){
        card = card1;
    }
     
    public Boolean getFull(){
        return full;
    }
    
    public void setFull (){
        full = true;
    }
    
    public void setNotFull (){
        full = false;
    }
    
    public static void emptyHand(){
       if (currentPlayer == 1)
       {  
         player1.hand.full = false;
         player1.hand.card = null;
       }
       if (currentPlayer == 2)
       {
         player2.hand.full = false;
         player2.hand.card = null;       
       }
       if (currentPlayer == 3)
       {
         player3.hand.full = false;
         player3.hand.card = null;         
       }
       if (currentPlayer == 4)
       {
         player4.hand.full = false;
         player4.hand.card = null;        
       }
    }
    
}
