package com.scientificgames.factory;

import com.scientificgames.calculator.*;

public class QuickTipFactory {

    public static QuickTip getInstance(String number) {

        switch (number) {
            case "1":
                return new FirstTypedCalculator();
            case "2":
                return new SecondTypedCalculator();
            case "3":
                return new ThirdTypedCalculator();
            default:
                return new FirstTypedCalculator();

        }

    }
}
