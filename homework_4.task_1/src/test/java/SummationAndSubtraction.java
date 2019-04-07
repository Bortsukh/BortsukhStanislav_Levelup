import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class SummationAndSubtraction {
    Calculator calculator;

    @BeforeMethod
    public void setCalculator(){
        calculator = new Calculator();
    }

    @Test(dataProvider = "twoLongNumbers", dataProviderClass = DataProviderClass.class)
    public void longSumTest(long a, long b){
        Assert.assertEquals(calculator.sum(a,b),a+b);
    }

    @Test(dataProvider = "twoDoubleNumbers", dataProviderClass = DataProviderClass.class)
    public void doubleSumTest(double a, double b){
        Assert.assertEquals(calculator.sum(a,b),a+b);
    }

    @Test(dataProvider = "twoLongNumbers", dataProviderClass = DataProviderClass.class)
    public void longSubTest(long a, long b){
        Assert.assertEquals(calculator.sub(a,b), a-b);
    }

    @Test(dataProvider = "twoDoubleNumbers", dataProviderClass = DataProviderClass.class)
    public void doubleSubTest(double a, double b){
        Assert.assertEquals(calculator.sub(a,b), a-b);
    }
}
