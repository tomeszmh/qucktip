import java.util.stream.IntStream;

import com.scientificgames.calculator.FirstTypedCalculator;

public class Main {

    public static void main(String args[]) {
        int ticketCount = 4;
        FirstTypedCalculator firstCalculator = new FirstTypedCalculator();
        IntStream.range(0, ticketCount).forEach(i -> System.out.println(firstCalculator.calculate().toString()));

    }
}
