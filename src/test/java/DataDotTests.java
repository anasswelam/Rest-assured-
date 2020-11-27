import org.testng.annotations.DataProvider;

public class DataDotTests {
    //Object return strings/char/numbers,..
    @DataProvider(name = " dataforpost")
    public Object[][] dataforpost(){

//        Object[][] data = new Object[2][3];
//        data[0][0] = "no";
//        data[0][1] = "sa";
//        data[0][2] = 5;
//        data[1][0] = "DPAK";
//        data[1][1] = "DGD";
//        data[1][2] = 9;
//
//        return data;
        return new Object[][]{
                {"nano","selem",6},
                {"hoho","lolo",3}

        };
    }

    @DataProvider(name = "dataDelete")
    public Object[] dataDelete(){
        return new Object[]{
                4,5
        };
    }
}
