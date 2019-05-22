package com.scientificgames.factory;

import com.scientificgames.calculator.FirstTypedCalculator;
import com.scientificgames.calculator.QuickTip;
import com.scientificgames.calculator.SecondTypedCalculator;
import com.scientificgames.calculator.ThirdTypedCalculator;

public class QuickTipFactory {

    public static QuickTip getInstance(int number) {

        switch (number) {
            case 1:
                return new FirstTypedCalculator();
            case 2:
                return new SecondTypedCalculator();
            case 3:
                return new ThirdTypedCalculator();
            default:
                throw new RuntimeException("Not valid game type: " + number);

        }

    }
}
