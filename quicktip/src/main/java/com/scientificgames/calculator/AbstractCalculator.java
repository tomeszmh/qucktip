package com.scientificgames.calculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.scientificgames.model.*;
import com.scientificgames.random.Randomizer;
import com.scientificgames.reader.ParameterReadable;

public abstract class AbstractCalculator<P extends Parameters> implements QuickTip {
    private Randomizer randomizer;

    private ParameterReadable<P> reader;

    private P params;

    public AbstractCalculator(ParameterReadable<P> reader) {
        this.reader = reader;
    }

    public void initRandomizer(int maxNumber) {
        randomizer = randomizer == null ? new Randomizer(maxNumber) : randomizer;
    }

    @Override
    public Ticket calculate() {
        try {
            params = reader.readParams();
            initRandomizer(params.getMaxNumber());
        } catch (IOException ioe) {
            System.err.println("Unable to read params!");
        }
        Ticket ticket = calculateTicket();

        return ticket;
    }

    private Ticket calculateTicket() {
        Ticket ticket = new Ticket();
        List<GamePanel> gamePanels = calculatePanels(params.getPanelCount());
        ticket.setGamePanels(gamePanels);
        return ticket;
    }

    private List<GamePanel> calculatePanels(int numberOfPanels) {
        List<GamePanel> gamePanels = new ArrayList<>(params.getPanelCount());

        IntStream.range(0, numberOfPanels).forEach(i ->
        {
            GamePanel gamePanel = new GamePanel();
            List<Integer> numbers = new ArrayList<>();
            generateNumbers(params.getLotteryNumbersCount(), numbers);
            gamePanel.setNumbers(numbers);
            gamePanels.add(gamePanel);
        });

        return gamePanels;
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
