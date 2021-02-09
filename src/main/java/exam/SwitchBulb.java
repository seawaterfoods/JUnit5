package exam;

public class SwitchBulb {
//    給一燈泡int[](ex:[2,1,3,5,4]),對應數字為開關按鈕，試問燈泡亮的次數，回傳int.
    public int switchBulb(int[] numArr){
        int temp = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = numArr.length-1; i>=0;i--)
        {
            if(numArr[i]<temp)
            {
                temp = numArr[i];
                ans++;
//                System.out.println("temp: "+temp+", ans: "+ans);
            }
        }
        return ans;
    }
}
