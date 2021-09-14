import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringCalculatorKata {

   public int add(String numbers) {
           if(numbers.isEmpty()){
               return 0;
           }else if(numbers.length() == 1){
               return Integer.parseInt(numbers);
           }else {
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

    
}
