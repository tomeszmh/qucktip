package com.scientificgames.model;

import java.util.List;

public class GamePanel {

    private List<Integer> numbers;

    public GamePanel(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString() + "\n";
    }
}
