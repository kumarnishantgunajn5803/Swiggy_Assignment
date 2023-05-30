package com.application;

public class SkipCard extends Card {
    public SkipCard(String color) {
        super(color, -1);
    }

    @Override
    public boolean isSpecialActionCard() {
        return true;
    }

    @Override
    public void performAction(Game game) {
        game.updateCurrentPlayerIndex();
    }
}
