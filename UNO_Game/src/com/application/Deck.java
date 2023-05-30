package com.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    private int drawIndex;

    public Deck() {
        this.cards = new ArrayList<>();
        this.drawIndex = 0;
        initializeDeck();
        shuffleDeck();
    }

    public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public int getDrawIndex() {
		return drawIndex;
	}

	public void setDrawIndex(int drawIndex) {
		this.drawIndex = drawIndex;
	}

	public Deck(List<Card> cards, int drawIndex) {
		super();
		this.cards = cards;
		this.drawIndex = drawIndex;
	}

	private void initializeDeck() {
        String[] colors = {"red", "blue", "green", "yellow"};
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (String color : colors) {
            cards.add(new Card(color, 0)); // Add one card of each color with value 0
            for (int value : values) {
                cards.add(new Card(color, value)); // Add cards with values 1-9 for each color
                cards.add(new Card(color, value));
            }
            cards.add(new SkipCard(color)); // Add special action cards: Skip, Reverse, Draw Two
            cards.add(new ReverseCard(color));
            cards.add(new DrawTwoCard(color));
        }
        // Add Wild Cards and Wild Draw Four Cards
        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard());
            cards.add(new WildDrawFourCard());
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (drawIndex >= cards.size()) {
            replenishDeck();
        }
        return cards.get(drawIndex++);
    }

    private void replenishDeck() {
        cards.subList(0, drawIndex).clear();
        drawIndex = 0;
        shuffleDeck();
    }

	public boolean isEmpty() {
		 return cards.isEmpty();
	}
}


