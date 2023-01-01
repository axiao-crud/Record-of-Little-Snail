# 1.Stream创建
适用于Collection对象，常用于List，Set，Map，数组
具体创建方式参考Stream_Learn中test2

顺序流和并行流 stream和parallelStream

# 2.Stream使用方法

创建-中间操作-终止操作
中间操作不会立刻执行，当有终止操作时才会执行

常见中间操作：
map,filter,sorted

常见终止操作：
collect-返回集合
collect-聚合 max ，sum，min，avg
collect-两种分组

foreach-遍历
match-匹配

具体案例参照Stream_Learn中test3

# 3.Stream本质
对List中元素进行处理，map是对其映射，filter是过滤，foreach是逐个处理，groupingby和partitioningBy是分组



# 4.并行流（多线程）


    

