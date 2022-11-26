/**
 * @description:递归算法时间复杂度
 * @Date: 2022-11-23-22--56
 * @author:A-Xiao
 **/
public class RecursionTimeComplexity {
    public static void main(String[] args) {

    }

    public  static int FeiBoNaQi(int n){

        if (n==0){return 1;}

        if (n==1){return 2;}

        return FeiBoNaQi(n-1)+FeiBoNaQi(n-2);
    }
    //这个递归写法有点意思。
    public static int FeiBoNaQi2(int first,int second,int n){
        if (n==0){ return 1;}
        if (n<3){return 2;}
        if (n==3){
            return first+second;
        }else {
            return  FeiBoNaQi2(second,first+second,n-1);
        }


    }


    public static  int FeiBoNaQi3(int n,int first,int second){
        if (n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        else if(n==3){
            return first+second;
        }else {
            return FeiBoNaQi3(n-1,second,second+first);
        }

    }


    // 求X的N次方普通写法
    public int algorithm01(int x,int n){
        int temp = x;
        for (int i=1;i<n;i++){
             temp = temp * x;
        }
        return temp;
    }
    //求x的N次方递归写法
    public int algorithm02(int x,int n){
        if (n==0){
            return 1;
        }else {
            return algorithm02(x,n-1)*x;
        }
    }
    //求x的N次方递归-进阶写法
    public int algorithm03(int x,int n){
        if (n==0){
            return 1;
        }
        int t = algorithm03(x,n/2);
        if (n%2==1){
            return t*t*x;
        }else{
            return t*t;
        }
    }






}
