package com.application;

public class Card {
    private String color;
    private int value;
    

    public void setColor(String color) {
		this.color = color;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Card() {
		super();
		 
	}

	public Card(String color, int value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public boolean isSpecialActionCard() {
        return false;  
    }

    public boolean canPlayOn(Card currentCard) {
        return color.equals(currentCard.getColor()) || value == currentCard.getValue();
    }

    public void performAction(Game game) {
         
    }
      //overloaded method to use in special case of WildCard and WildDrawFourCard
	public void performAction(Game game, String chosenColor) {
		// TODO Auto-generated method stub
		
	}
}
