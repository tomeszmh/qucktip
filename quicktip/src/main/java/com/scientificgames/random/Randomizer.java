package com.scientificgames.random;

import java.security.SecureRandom;

public class Randomizer {
    private final int maxValue;
    private final int minValue = 1;
    private SecureRandom random = new SecureRandom();

    public Randomizer(int maxValue) {
        this.maxValue = maxValue;
    }

    public int generate() {
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }
}
