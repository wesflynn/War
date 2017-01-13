/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 *
 * @author wes_4
 */
public class Card {
    private String faceName,suit;
    private int faceValue;
    
    public Card(String face, String suit, int value)
    {
        faceName = face;
        setSuit(suit);
        setValue(value);
    }
    /**
     * this method will validate the suit
     */
    private void setSuit(String suit)
    {
        if(suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") ||suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("clubs"))
            this.suit=suit;
        else
            throw new IllegalArgumentException("suit must be hearts,diamond,spades or clubs");
    }
    
    private void setValue(int value)
    {
        if (value<2 || value>14)
            throw new IllegalArgumentException("face value must be 2-14 inclusive");
        else
            faceValue = value;
    }
    
    @Override
    public String toString()
    {
        return faceName + " of " + suit;
    }

    public String getFaceName() {
        return faceName;
    }

    public String getSuit() {
        return suit;
    }

    public int getFaceValue() {
        return faceValue;
    }
    
            
}
