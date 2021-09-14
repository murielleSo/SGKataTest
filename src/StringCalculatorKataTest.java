import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorKataTest {
    private StringCalculatorKata stringCalculatorKata = new StringCalculatorKata();

    @Test
    public void shouldReturn0ForNumbersIsEmpty(){
          Assert.assertEquals(stringCalculatorKata.add(""), 0);
    }

    @Test
    public void shouldReturn3ForNumbersIs3(){
        Assert.assertEquals(stringCalculatorKata.add("3"), 3);
    }

    @Test
    public void shouldReturn6ForNumbersIsNotEmpty(){
        Assert.assertEquals(stringCalculatorKata.add("1,2,3"), 6);
    }
}
