import java.util.stream.IntStream;

import com.scientificgames.calculator.QuickTip;
import com.scientificgames.factory.QuickTipFactory;

public class Main {


    public static void main(String args[]) {
        int ticketCount = Integer.valueOf(args[0]);
        String calculatorType = args[1];

        QuickTip firstCalculator = QuickTipFactory.getInstance(calculatorType);

        IntStream.range(0, ticketCount)
                .forEach(i -> System.out.println(firstCalculator.calculate()));

    }
}
