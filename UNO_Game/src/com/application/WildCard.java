package com.application;

public class WildCard extends Card {
    public WildCard() {
        super("wild", -1);
    }

    @Override
    public boolean isSpecialActionCard() {
        return true;
    }

    @Override
    public void performAction(Game game, String chosenColor) {
        game.setCurrentColor(chosenColor);
        game.updateCurrentPlayerIndex();
    }
}