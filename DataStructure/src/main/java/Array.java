import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @description:数组学习
 * @Date: 2022-11-21-17--43
 * @author:A-Xiao
 **/
public class Array {
    private static  final  Logger log = Logger.getLogger("ArrayLogger");
    public static void main(String[] args) {
        int [] a = {1,3,5};

    }





    //二分查找[left,right]
    public static int binarySearch(int nums[],int target ){
        int left = 0;
        int right = nums.length-1;
        int middle = (left+right)/2;
        for (;left<=right;middle=(left+right)/2){
            if(nums[middle]==target){
                return middle;
            }else if(nums[middle]>target){
                right = middle-1;
            }else  if(nums[middle]<target){
                left = middle+1;
            }



        }

        return -1;
    }
    //二分查找[left,right)
    public static int binarySearch2(int nums[],int target ){
        int left = 0;
        int right = nums.length;
        int middle =(left+right)/2;
        for(;left<right;middle=(left+right)/2){
            if(nums[middle]==target){
                return middle;
            }
            if(nums[middle]>target){
                right = middle;
            }
            if(nums[middle]<target){
                left =middle+1;
            }
        }

        return -1;
    }
    //二分查找拓展-查找插入元素位置
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right =nums.length-1;
        for(;left<=right;){
            int middle=(left+right)/2;
            if(nums[middle]==target){
                return middle;
            }
            if(nums[middle]<target){
                left = middle+1;
            }
            if(nums[middle]>target){
                right = middle-1;
            }
        }

        return left;
    }

    //移除元素-双指针写法
    public static int  removeElement(int []nums,int val){
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
        }

        return left;
    }

    

}
