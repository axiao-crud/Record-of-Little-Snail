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

    //有序数组的平方 时间复杂度O（n+nlogn）
    public static int[] arraySquare(int nums[]){
        for (int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    //有序数组的平方 时间复杂度O(n) 双指针法
    public static int[] arraySquare2(int nums[]){
        int result[] = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        for (int index = nums.length-1;left<=right;index--){
            if (nums[left]*nums[left]>nums[right]*nums[right]){
                result[index]=nums[left]*nums[left];
                left++;
            }else{
                result[index]=nums[right]*nums[right];
                right--;
            }
        }
        return result;
    }

    

}
