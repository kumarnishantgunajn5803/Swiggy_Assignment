package com.application;

public class ReverseCard extends Card {
    public ReverseCard(String color) {
        super(color, -1);
    }

    @Override
    public boolean isSpecialActionCard() {
        return true;
    }

    @Override
    public void performAction(Game game) {
        game.setReverseDirection(!game.isReverseDirection());
        game.updateCurrentPlayerIndex();
    }
}
