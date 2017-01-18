/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;

/**
 *
 * @author wes_4
 */
public class GameOfWar {
    
    private ArrayList<Card>p1Hand;
    private ArrayList<Card>p2Hand;

    public GameOfWar()
    {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>(); 
        
        DeckOfCards theDeck = new DeckOfCards();
        theDeck.shuffle();
        
        dealTheCards(theDeck);
    }
    
    
    private void dealTheCards(DeckOfCards theDeck)
    {
        for (int cardNum=0;cardNum<52;cardNum++)
        {
           if(cardNum % 2 ==0)
               p1Hand.add(theDeck.dealTopCard());
           else
               p2Hand.add(theDeck.dealTopCard());
        }
    }
    
    public void playTheGame()
    {
        while (!p1Hand.isEmpty()&& !p2Hand.isEmpty())
        {
            playHand();
        }
        if (p1Hand.isEmpty())
            System.out.println("player 2 is the winner!");
        else
            System.out.println("player 1 is the winner!");
    }
    /**
     * this method draws card from hand and compares against opponents top card
     */
    private void playHand()
    {
        Card p1Card = p1Hand.remove(0);
        Card p2Card = p2Hand.remove(0);
        
        System.out.printf("player 1 %s cards in hand: %d", p1Card,p1Hand.size()+1);
        System.out.printf("\tplayer 2 %s cards in hand: %d%n", p2Card,p2Hand.size()+1);        
                
        if (p1Card.getFaceValue()>p2Card.getFaceValue())
        {
            p1Hand.add(p1Card);
            p1Hand.add(p2Card);
                    
        }
        else if ((p2Card.getFaceValue()>p1Card.getFaceValue()))
        {
            p2Hand.add(p1Card);
            p2Hand.add(p2Card);
        }
        
        else
        {
            ArrayList<Card> warPile = new ArrayList<>();
            warPile.add(p2Card);
            warPile.add(p1Card);
            playWarHand(warPile);
        }
    }
    
    private void playWarHand(ArrayList<Card> warPile)
    {
        if (p1Hand.size()<3)
        {
            p2Hand.addAll(p1Hand);
            p1Hand.clear();
            p2Hand.addAll(warPile);
            return;
        }
        
         if (p2Hand.size()<3)
        {
            p1Hand.addAll(p1Hand);
            p2Hand.clear();
            p1Hand.addAll(warPile);
            return;
        }
         
         warPile.add(p1Hand.remove(0));
         warPile.add(p1Hand.remove(0));
         warPile.add(p2Hand.remove(0));
         warPile.add(p2Hand.remove(0));
                 
         Card p1Card=p1Hand.remove(0);
         Card p2Card=p2Hand.remove(0);
         
         System.out.printf("%n%n war%n");
         System.out.printf("player 1 %s cards in hand: %d", p1Card,p1Hand.size()+1);
         System.out.printf("\tplayer 2 %s cards in hand: %d%n", p2Card,p2Hand.size()+1);
         
         if (p1Card.getFaceValue()>p2Card.getFaceValue())
         {
             p1Hand.addAll(warPile);
             p1Hand.add(p1Card);
             p1Hand.add(p2Card);
                     
         }
         
         else if (p1Card.getFaceValue()>p2Card.getFaceValue())
         {
             p1Hand.addAll(warPile);
             p1Hand.add(p1Card);
             p1Hand.add(p2Card);
                     
         }
         
         else
         {
             warPile.add(p2Card);
             warPile.add(p2Card);
             this.playWarHand(warPile);
             
         }
    }
    
    
}
