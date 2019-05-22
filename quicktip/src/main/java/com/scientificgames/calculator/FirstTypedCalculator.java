package com.scientificgames.calculator;

import com.scientificgames.model.Parameters;
import com.scientificgames.reader.FirstReader;

public class FirstTypedCalculator extends Calculator {
    public FirstTypedCalculator() {
        super(new FirstReader(Parameters.class));
    }

}
