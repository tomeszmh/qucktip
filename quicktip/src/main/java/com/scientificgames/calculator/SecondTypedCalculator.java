package com.scientificgames.calculator;


import com.scientificgames.model.Parameters;
import com.scientificgames.reader.SecondReader;

public class SecondTypedCalculator extends AbstractCalculator {
    public SecondTypedCalculator() {
        super(new SecondReader(Parameters.class));
    }
}
