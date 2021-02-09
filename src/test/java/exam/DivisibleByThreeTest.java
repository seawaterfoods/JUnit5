package exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByThreeTest {
//    以String儲存數字 “ex:081,21,1234”，每次只能變動一位數，變動結果需被3整除，試問 有幾種可能，回傳數字。

    @Test
    public void Question1(){
        String strNum = "081";
        int ans = 7;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[381,681,981],[021,051],[084,087]");
    }

    @Test
    public void Question2(){
        String strNum = "01";
        int ans = 6;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[21,51,81],[03,06,09]");
    }

    @Test
    public void Question3(){
        String strNum = "1234";
        int ans = 14;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[0234,3234,4234,9234],[1134,1434,1734],[1224,1254,1284],[1230,1233,1236,1239]");
    }

    @Test
    public void Question4(){
        String strNum = "232";
        int ans = 9;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[132,432,732],[222,252,282],[231,234,237]");
    }

    @Test
    public void Question5(){
        String strNum = "0091";
        int ans = 13;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[2091,5091,8091],[0291,0591,0891],[0021,0051,0081],[0090,0093,0096,0099]");
    }

    @Test
    public void Question6(){
        String strNum = "1";
        int ans = 3;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[3,6,9]");
    }

    @Test
    public void Question7(){
        String strNum = "3";
        int ans = 2;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[6,9]");
    }

    @Test
    public void Question8(){
        String strNum = "31";
        int ans = 7;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[21,51,81],[30,33,36,39]");
    }

    @Test
    public void Question9(){
        String strNum = "42";
        int ans = 4;

        DivisibleByThree DBT = new DivisibleByThree();
        Assertions.assertEquals(DBT.divisibleByThree(strNum),ans,
                "答案錯誤!；[12,72],[45,48]");
    }

}
