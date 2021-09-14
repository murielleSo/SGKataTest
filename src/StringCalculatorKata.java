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
               //Stream<String> splitNumbers = Arrays.stream(numbers.split(","));
               return Arrays.stream(numbers.split(","))
                       .mapToInt(Integer::parseInt)
                       .sum();
           }
   }

    public int add(String... numbers) {
        List<String> list = new ArrayList<>();
        for (String number : numbers) {
            Arrays.stream(number.split(","))
                    .forEach(numb -> list.add(numb));
        }
        return list.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public int addWithTwoDelimeter(String numbers) {

        return Arrays.stream(numbers.split(",|\n"))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public int addWithManyDelimeter(String numbers) {
       if(numbers.startsWith("//")) {
           String delimeter = numbers.charAt(2)+"|\n";
           String newNumbers = numbers.substring(2,numbers.length());

           return Arrays.stream(newNumbers.split(delimeter))
                   .filter(numb -> !"".equals(numb))
                   .mapToInt(Integer::parseInt)
                   .sum();
       }
       return 0;
    }
}
