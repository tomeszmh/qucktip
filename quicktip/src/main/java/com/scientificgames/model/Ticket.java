package com.scientificgames.model;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    List<GamePanel> gamePanels;

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
        return gamePanels.stream().map(panel -> panel.toString()).collect(Collectors.joining());
    }
}
