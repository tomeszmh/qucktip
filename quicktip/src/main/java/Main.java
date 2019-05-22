import java.util.stream.IntStream;

import com.scientificgames.calculator.QuickTip;
import com.scientificgames.factory.QuickTipFactory;

public class Main {

    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.println("No argument is given");
            return;
        }

        int ticketCount = Integer.valueOf(args[0]);
        int calculatorType = args.length > 1 ? Integer.valueOf(args[1]) : -1;

        QuickTip quickTipCalculator = QuickTipFactory.getInstance(calculatorType);

        IntStream.range(0, ticketCount)
                .forEach(i -> System.out.println(quickTipCalculator.calculate()));

    }
}
