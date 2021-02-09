package exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FillBottleTest {
//    給水瓶數k（if k=3表示有容量為1、2、3的水瓶）水量m，需要以水瓶裝水量m剛好裝完，且不能裝一半，
//    試問最小裝瓶數為何（如正確答案則回傳-1）

    @Test
    public void Question1(){
        int K=3 ,M=5;
        int ans = 2;

        FillBottle FB = new FillBottle();
        Assertions.assertEquals(FB.fillBottle(K,M),ans,
                "答案錯誤!；[2],[3]");
    }

    @Test
    public void Question2(){
        int K=19 ,M=6;
        int ans = 1;

        FillBottle FB = new FillBottle();
        Assertions.assertEquals(FB.fillBottle(K,M),ans,
                "答案錯誤!；[6]");
    }

    @Test
    public void Question3(){
        int K=3 ,M=8;
        int ans = -1;

        FillBottle FB = new FillBottle();
        Assertions.assertEquals(FB.fillBottle(K,M),ans,
                "答案錯誤!；沒辦法剛好裝滿。");
    }

    @Test
    public void Question4(){
        int K=9 ,M=18;
        int ans = 3;

        FillBottle FB = new FillBottle();
        Assertions.assertEquals(FB.fillBottle(K,M),ans,
                "答案錯誤!；[9],[6],[3]");
    }

    @Test
    public void Question5(){
        int K=11 ,M=34;
        int ans = 4;

        FillBottle FB = new FillBottle();
        Assertions.assertEquals(FB.fillBottle(K,M),ans,
                "答案錯誤!；[4],[9],[10],[11]");
    }

    @Test
    public void Question6(){
        int K=14 ,M=106;
        int ans = -1;

        FillBottle FB = new FillBottle();
        Assertions.assertEquals(FB.fillBottle(K,M),ans,
                "答案錯誤!；");
    }


}
