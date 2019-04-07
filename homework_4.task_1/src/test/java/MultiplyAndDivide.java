import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.qa.at.calculator.Calculator;

public class MultiplyAndDivide {
    Calculator calculator;

    @BeforeMethod
    public void setOne(){
        calculator = new Calculator();
    }

    @Test(dataProvider = "twoLongNumbers", dataProviderClass = DataProviderClass.class)
    public void longMultTest(long a, long b) {
        Assert.assertEquals(calculator.mult(a, b), a * b);
    }
    @Test(dataProvider="twoDoubleNumbers", dataProviderClass = DataProviderClass.class)
    public void doubleMultTest(double a, double b) {
        Assert.assertEquals(calculator.mult(a,b), a*b);
    }
    @Test(dataProvider = "twoLongNumbers", dataProviderClass = DataProviderClass.class)
    public void longDivTest(long a, long b) {
        Assert.assertEquals(calculator.div(a,b), a/b);
    }
    @Test(dataProvider = "twoLongNumbers", dataProviderClass = DataProviderClass.class)
    public void doubleDivTest(double a, double b) {
        Assert.assertEquals(calculator.div(a,b), a/b);
    }
}
