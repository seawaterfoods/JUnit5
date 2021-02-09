package exam;

public class DivisibleByThree {
//    以string儲存數字 “ex:081,21,1234”，每次只能變動一位數，變動結果需被3整除，試問 有幾種可能，回傳數字。

    public int divisibleByThree(String strNum){
        int num = Integer.parseInt(strNum);
        int len = strNum.length();
        int ans = 0;
        char[] strCharArr = strNum.toCharArray();

        for (int i = 0 ; i<len ;i++)
        {
            int temp = strCharArr[i]-'0';
            System.out.println("temp:"+temp);
            if (num%3!=0 && (num-temp)%3!=0)
            {
                ans+=3;
            }
            else if (num%3==0 && (num-temp)%3==0)
            {
                ans+=3;
            }
            else if (num%3==0 && (num-temp)%3!=0)
            {
                ans+=2;
            }
            else if (num%3!=0 && (num-temp)%3==0)
            {
                ans+=4;
            }
            if(num-temp==0)
                ans--;
            System.out.println("ans:"+ans);
        }
        return ans;
    }
}
