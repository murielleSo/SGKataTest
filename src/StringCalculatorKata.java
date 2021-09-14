import java.util.Arrays;


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
        return 0;
    }

    /*public int Add(String numbers) {
        return 0;
    }*/
}
