package com.application;

import java.util.ArrayList;
import java.util.List;
public class Game {
    private List<Player> players;
    private Deck deck;
    private Card currentCard;
    private int currentPlayerIndex;
    private boolean reverseDirection;
    private String currentColor;

    public Game(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
        this.currentCard = deck.drawCard();
        this.currentPlayerIndex = 0;
        this.reverseDirection = false;
        distributeInitialCards();
    }
    

    public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public Deck getDeck() {
		return deck;
	}


	public void setDeck(Deck deck) {
		this.deck = deck;
	}


	public Card getCurrentCard() {
		return currentCard;
	}


	public void setCurrentCard(Card currentCard) {
		this.currentCard = currentCard;
	}


	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}


	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}


	public Game() {
		super();
		 
	}


	public Game(List<Player> players, Deck deck, Card currentCard, int currentPlayerIndex, boolean reverseDirection) {
		super();
		this.players = players;
		this.deck = deck;
		this.currentCard = currentCard;
		this.currentPlayerIndex = currentPlayerIndex;
		this.reverseDirection = reverseDirection;
	}


	private void distributeInitialCards() {
        for (Player player : players) {
            List<Card> initialCards = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                initialCards.add(deck.drawCard());
            }
            player.receiveInitialCards(initialCards);
        }
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void playCard(Card card) {
        currentCard = card;
        getCurrentPlayer().playCard(card);
        card.performAction(this);
        updateCurrentPlayerIndex();
    }

    public void updateCurrentPlayerIndex() {
        int direction = reverseDirection ? -1 : 1;
        currentPlayerIndex = (currentPlayerIndex + direction) % players.size();
        if (currentPlayerIndex < 0) {
            currentPlayerIndex += players.size();
        }
    }

    public boolean isReverseDirection() {
        return reverseDirection;
    }

    public void setReverseDirection(boolean reverseDirection) {
        this.reverseDirection = reverseDirection;
    }

    public void checkWinConditions() {
        for (Player player : players) {
            if (player.getHandSize() == 0) {
                declareWinner(player);
                return;
            }
        }
    }
    
    public void declareWinner(Player player) {
        System.out.println("Player " + player.getPlayerName() + " wins!");
    }


    public Player getNextPlayer() {
        int numPlayers = players.size();
        int nextPlayerIndex;
        
        if (reverseDirection) {
            nextPlayerIndex = (currentPlayerIndex - 1 + numPlayers) % numPlayers;
        } else {
            nextPlayerIndex = (currentPlayerIndex + 1) % numPlayers;
        }
        
        return players.get(nextPlayerIndex);
    }


    


	public void setCurrentColor(String chosenColor) {
		currentColor = chosenColor;
		
	}


	public void moveToNextPlayer() {
        // Increment the current player index
        currentPlayerIndex++;

        // Check if the index exceeds the maximum number of players
        if (currentPlayerIndex >= players.size()) {
            // If so, wrap around to the first player
            currentPlayerIndex = 0;
        }
    }
    
}

