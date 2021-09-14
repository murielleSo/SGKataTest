import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorKataTest {
    private final StringCalculatorKata stringCalculatorKata = new StringCalculatorKata();

    @Test
    public void shouldReturn0ForNumbersIsEmpty(){
          Assert.assertEquals(stringCalculatorKata.add(""), 0);
    }

    @Test
    public void shouldReturn3ForNumbersIs3(){
        Assert.assertEquals(stringCalculatorKata.add("3"), 3);
    }

    @Test
    public void shouldReturn3ForNumbersIsNotEmpty(){
        Assert.assertEquals(stringCalculatorKata.add("1,2"), 3);
    }

    @Test
    public void shouldReturn26ForUnknowNumbers(){
        Assert.assertEquals(stringCalculatorKata.add("1,2,3", "10,10"), 26);
    }

    @Test
    public void shouldReturn6ForTwoDelimeter(){
        Assert.assertEquals(stringCalculatorKata.addWithTwoCommaDelimeter("1\n2,3"), 6);
    }

    @Test
    public void shouldReturn3ForAnyDelimeter(){
        Assert.assertEquals(stringCalculatorKata.addWithAnyDelimeter("//;\n1;2"), 3);
    }

    @Test
    public void shouldReturn6ForAnyDelimeter(){
        Assert.assertEquals(stringCalculatorKata.addWithAnyDelimeter("//&\n1&2&3"), 6);
    }


}
