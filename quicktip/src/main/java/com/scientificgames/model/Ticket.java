package com.scientificgames.model;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private List<GamePanel> gamePanels;

    public Ticket(List<GamePanel> gamePanels) {
        this.gamePanels = gamePanels;
    }

    public Ticket() {
    }

    public List<GamePanel> getGamePanels() {
        return gamePanels;
    }

    public void setGamePanels(List<GamePanel> gamePanels) {
        this.gamePanels = gamePanels;
    }

    @Override
    public String toString() {
        return "Generated ticket: \n" + gamePanels.stream().map(GamePanel::toString).collect(Collectors.joining());
    }
}
