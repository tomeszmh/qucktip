package com.scientificgames.calculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.scientificgames.model.*;
import com.scientificgames.random.Randomizer;
import com.scientificgames.reader.ParameterReadable;

public abstract class AbstractCalculator implements QuickTip {
    private Randomizer randomizer;

    private ParameterReadable reader;

    private Parameters params;

    public AbstractCalculator(ParameterReadable reader) {
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
            throw new RuntimeException("Unable to read params!");
        }

        return calculateTicket();
    }

    private Ticket calculateTicket() {
        return new Ticket(calculatePanels(params.getPanelCount()));
    }

    private List<GamePanel> calculatePanels(int numberOfPanels) {
        return IntStream.range(0, numberOfPanels)
                .mapToObj(i -> new GamePanel(generateNumbers(params.getLotteryNumbersCount())))
                .collect(Collectors.toList());
    }

    private List<Integer> generateNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(0, count).forEach(j -> numbers.add(generateNonExistingNumber(numbers)));
        return numbers;
    }

    private int generateNonExistingNumber(List<Integer> list) {
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
