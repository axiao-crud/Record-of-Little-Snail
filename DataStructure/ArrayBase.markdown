# 1.数组基础
关键字：
    连续内存地址空间存放，有索引，索引从0开始,数组元素不能删除，只能覆盖。

Array ,index,length
int [] a = {1,2,3};
int [] a = new int[3];

# 2.数组算法
1.二分查找（衍生题：查找插入元素）
(使用前提：有序不重复数组)


容易错的点:
两种写法 [left,right]
边界条件 left<=right;
left =middle +1;
right=middle-1;

和[left,right)
left <right 
left =middle+1;
right =middle;


2.移除元素-双指针写法