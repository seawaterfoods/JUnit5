package exam;

public class FillBottle {
//    給水瓶數k（if k=3表示有容量為1、2、3的水瓶）水量m，需要以水瓶裝水量m剛好裝完，且不能裝一半，
//    試問最小裝瓶數為何（如正確答案則回傳-1）

    public int fillBottle(int K,int M){

        if (M>=((K+1)*K/2))
            return -1;
        int ans = 0;
        for (int i=K;i>0;i--)
        {
            if (M-i>=0)
            {
                System.out.println("共 "+M+" 升水");
                M-=i;
                ans++;
                System.out.println("扣除 "+i+" 升");
            }
        }
        if (M!=0)
            return -1;
        return ans;
    }
}
