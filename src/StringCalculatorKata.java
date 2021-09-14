import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StringCalculatorKata {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        } else {
            return sum(splitNumbers(numbers, ","));
        }
    }

    public int add(String... numbers) {
        List<String> list = new ArrayList<>();

        for (String number : numbers) {

            splitNumbers(number, ",")
                    .forEach(numb -> list.add(numb));
        }
        return sum(list.stream());
    }

    public int addWithTwoCommaDelimeter(String numbers) {
        return sum(splitNumbers(numbers, ",|\n"));
    }

    public int addWithAnyDelimeter(String numbers) {
        if (numbers.startsWith("//")) {
            String delimeter = numbers.substring(2, numbers.indexOf("\n")) + "|\n";

            String newNumbers = numbers.substring(numbers.indexOf("\n") - 1, numbers.length());

            return sum(splitNumbers(newNumbers, delimeter)
                    .filter(numb -> !"".equals(numb)));
        }
        return 0;
    }

    public void addthrowsExeptionWithNegativeNumbers(String numbers) {
        List<Integer> list = new ArrayList<>();
        splitNumbers(numbers, ",")
                .mapToInt(Integer::parseInt)
                .filter(numb -> numb < 0)
                .forEach(negative -> list.add(negative));

        if (!list.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed " + list.toString());
        }
    }

    private static Stream<String> splitNumbers(String numbersToSplit, String delimeter) {
        return Arrays.stream(numbersToSplit.split(delimeter));
    }

    private static int sum(Stream<String> streamNumbers) {
        return streamNumbers
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
