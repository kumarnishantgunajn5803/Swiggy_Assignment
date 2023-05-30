package com.application;

public class NumberedCard extends Card {
    public NumberedCard(String color, int value) {
        super(color, value);
    }

    @Override
    public boolean isSpecialActionCard() {
        return false;
    }
    
    @Override
    public void performAction(Game game) {
        // Get the current player
        Player currentPlayer = game.getCurrentPlayer();

        // Get the current card in play
        Card currentCard = game.getCurrentCard();

        // Check if the current player has a valid card to play
        if (currentPlayer.hasValidCardToPlay(currentCard)) {
            // Player has a valid card to play, continue the game

            // Remove the played card from the player's hand
            currentPlayer.removeCardFromHand(this);

            // Set this card as the current card in play
            game.setCurrentCard(this);

            // Update the current color to match the played card's color
            game.setCurrentColor(this.getColor());

            // Proceed to the next player
            game.moveToNextPlayer();
        } else {
            // Player does not have a valid card to play, they must draw a card
            currentPlayer.drawCard(game.getDeck());

            // Skip the player's turn
            currentPlayer.skipTurn();

            // Proceed to the next player
            game.moveToNextPlayer();
        }
    }
}
