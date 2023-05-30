package com.application;

public class WildDrawFourCard extends Card {
    public WildDrawFourCard() {
        super("wild", -1);
    }

    @Override
    public boolean isSpecialActionCard() {
        return true;
    }

    @Override
    public void performAction(Game game, String chosenColor) {
        Player currentPlayer = game.getCurrentPlayer();
        Player nextPlayer = game.getNextPlayer();
        Deck deck = game.getDeck();

        for (int i = 0; i < 4; i++) {
            Card drawnCard = deck.drawCard();
            currentPlayer.addCardToHand(drawnCard);
        }
        
        currentPlayer.skipTurn();
        game.setCurrentColor(chosenColor);
        game.updateCurrentPlayerIndex();
    }
}
