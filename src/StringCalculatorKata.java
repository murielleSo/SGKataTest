import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class StringCalculatorKata {

   public int add(String numbers) {
           if(numbers.isEmpty()){
               return 0;
           }else if(numbers.length() == 1){
               return Integer.parseInt(numbers);
           }else {
               String delimeter = ",";

               return sum(splitNumbers(numbers, delimeter));
           }
   }

    public int add(String... numbers) {
        List<String> list = new ArrayList<>();
        String delimeter = ",";
        for (String number : numbers) {

            splitNumbers(number, delimeter)
                    .forEach(numb -> list.add(numb));
        }
        return sum(list.stream());
    }

    public int addWithTwoCommaDelimeter(String numbers) {
        String delimeter = ",|\n";

        return sum(splitNumbers(numbers, delimeter));
    }

    public int addWithAnyDelimeter(String numbers) {
       if(numbers.startsWith("//")) {
           String delimeter = numbers.charAt(2)+"|\n";
           String newNumbers = numbers.substring(2,numbers.length());

           return sum(splitNumbers(newNumbers, delimeter)
                      .filter(numb -> !"".equals(numb)));
       }
       return 0;
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
