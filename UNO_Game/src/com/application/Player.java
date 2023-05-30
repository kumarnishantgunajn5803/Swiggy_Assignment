package com.application;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerId;
    private String playerName;
    private List<Card> hand;
    private boolean skipTurn;

    public Player(String playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.hand = new ArrayList<>();
        this.skipTurn=false;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Card> getHand() {
        return hand;
    }
    public int getHandSize() {
        return hand.size();
    }
    public void receiveInitialCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public Card drawCard(Deck deck) {
        Card card = deck.drawCard();
        hand.add(card);
        return card;
    }

    public boolean hasValidCardToPlay(Card currentCard) {
        for (Card card : hand) {
            if (card.canPlayOn(currentCard)) {
                return true;
            }
        }
        return false;
    }

    public Card playCard(Card card) {
        hand.remove(card);
        return card;
    }

    public void applySpecialCardEffect(Card card, Game game) {
        card.performAction(game);
    }

	 public void addCardToHand(Card card) {
        hand.add(card);
    }

	public void skipTurn() {
		skipTurn = true;
		
	}

	public void removeCardFromHand( Card card) {
		 hand.remove(card);
		
	}
}

