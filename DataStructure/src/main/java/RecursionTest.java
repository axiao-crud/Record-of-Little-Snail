

/**
 * @description:浙大1.1.2视频
 * @Date: 2022-11-22-00--37
 * @author:A-Xiao
 **/
public class RecursionTest {
    public static void main(String[] args) {
        long forStart = System.currentTimeMillis();
        //count from 100 , 1000, 10000,100000
        int count = 100000;
        for (int i =0;i<count;i++){
            System.out.print(i);
        }
        long forEnd = System.currentTimeMillis();
        System.out.println("\nforTime = "+(forEnd-forStart));

        long recursionStart = System.currentTimeMillis();

         recursionTimeTest(count);
        long recursionEnd = System.currentTimeMillis();
        System.out.println("\nrecursionTime = "+(recursionEnd-recursionStart));

    }


    public static void recursionTimeTest(int n){
        if (n==0){
            System.out.print(n);
        }else
        {
            System.out.print(n);
            recursionTimeTest(n-1);
        }
    }
}
