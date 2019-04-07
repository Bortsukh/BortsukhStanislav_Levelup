import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider
    public Object [][] twoLongNumbers(){
        return new Object[][]{
                {-10, -10},
                {5, 5},
                {-3, 5},
                {4, 53}
        };
    }
    @DataProvider
    public Object [][] twoDoubleNumbers(){
        return new Object[][]{
                {-4.3, -2.0},
                {3.3, 14.1},
                {20.1, 10.2},
                {-1.5, 80}
        };
    }
}
