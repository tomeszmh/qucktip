package com.scientificgames.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.scientificgames.model.*;
import com.scientificgames.random.Randomizer;
import com.scientificgames.reader.ParameterReadable;

public abstract class Calculator<P extends Parameters> implements QuickTip {
    private Randomizer randomizer;

    private ParameterReadable<P> reader;

    private P params;

    public Calculator(ParameterReadable<P> reader) {
        this.reader = reader;
    }


    @Override
    public Ticket calculate() {
        params = reader.readParams();
        Ticket ticket = new Ticket();
        List<GamePanel> gamePanels = new ArrayList<>(params.getPanelCount());
        GamePanel gamePanel = new GamePanel();

        List<Integer> numbers = new ArrayList<>();

        generateNumbers(params.getLotteryNumbersCount(), numbers);
        gamePanel.setNumbers(numbers);

        gamePanels.add(gamePanel);
        ticket.setGamePanels(gamePanels);

        return ticket;
    }

    private void generateNumbers(int count, List<Integer> numbers) {
        IntStream.range(0, count).forEach(j -> numbers.add(createNonExistingNumber(numbers)));
    }

    int createNonExistingNumber(List<Integer> list) {
        int number = randomizer.generate();
        while (list.contains(number)) {
            number = randomizer.generate();
        }
        return number;
    }

    public Randomizer getRandomizer() {
        return randomizer;
    }

    public void setRandomizer(Randomizer randomizer) {
        this.randomizer = randomizer;
    }
}
