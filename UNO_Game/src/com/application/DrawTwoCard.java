package com.application;

public class DrawTwoCard extends Card {
    public DrawTwoCard(String color) {
        super(color, -1);
    }

    @Override
    public boolean isSpecialActionCard() {
        return true;
    }

    @Override
    public void performAction(Game game) {
        Player nextPlayer = game.getCurrentPlayer();
        nextPlayer.drawCard(game.getDeck());
        nextPlayer.drawCard(game.getDeck());
        game.updateCurrentPlayerIndex();
    }
}

