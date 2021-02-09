package exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwitchBulbTest {
//    給一燈泡int[](ex:[2,1,3,5,4]),對應數字為開關按鈕，試問燈泡亮的次數，回傳int.


    @Test
    public void Question1(){
        int[] numArr={2,1,3,5,4};
        int ans = 3;

        SwitchBulb SB = new SwitchBulb();
        Assertions.assertEquals(SB.switchBulb(numArr),ans,
                "答案錯誤!；{2,1],3,5,4}:1,{2,1,3],5,4}:2,{2,1,3,5,4]}:3");
    }

    @Test
    public void Question2(){
        int[] numArr={2,4,3,5,1};
        int ans = 1;

        SwitchBulb SB = new SwitchBulb();
        Assertions.assertEquals(SB.switchBulb(numArr),ans,
                "答案錯誤!；{2,4,3,5,1]}:1");
    }

    @Test
    public void Question3(){
        int[] numArr={2,1,3};
        int ans = 2;

        SwitchBulb SB = new SwitchBulb();
        Assertions.assertEquals(SB.switchBulb(numArr),ans,
                "答案錯誤!；{2,1],3}:1,{2,1,3]}:2");
    }

    @Test
    public void Question4(){
        int[] numArr={2,1,3,6,7,8,5,4};
        int ans = 3;

        SwitchBulb SB = new SwitchBulb();
        Assertions.assertEquals(SB.switchBulb(numArr),ans,
                "答案錯誤!；{{2,1],3,6,7,8,5,4}:1,{2,1,3],6,7,8,5,4}:2,{2,1,3,6,7,8,5,4]}:3");
    }

    @Test
    public void Question5(){
        int[] numArr={1,4,2,6,3,8,5,7};
        int ans = 5;

        SwitchBulb SB = new SwitchBulb();
        Assertions.assertEquals(SB.switchBulb(numArr),ans,
                "答案錯誤!；{1],4,2,6,3,8,5,7}:1,{1,4,2],6,3,8,5,7}:2,{1,4,2,6,3],8,5,7}:3,{1,4,2,6,3,8,5],7}:4,{1,4,2,6,3,8,5,7]}:5");
    }

    @Test
    public void Question6(){
        int[] numArr={1,4,2,3,5};
        int ans = 4;

        SwitchBulb SB = new SwitchBulb();
        Assertions.assertEquals(SB.switchBulb(numArr),ans,
                "答案錯誤!；{1],4,2,3,5}:1,{1,4,2],3,5}:2,{1,4,2,3],5}:3,{1,4,2,3,5]}:4");
    }
}
