package com.scientificgames.calculator;

import com.scientificgames.model.Parameters;
import com.scientificgames.reader.ThirdReader;

public class ThirdTypedCalculator extends AbstractCalculator<Parameters> {
    public ThirdTypedCalculator() {
        super(new ThirdReader(Parameters.class));
    }
}
