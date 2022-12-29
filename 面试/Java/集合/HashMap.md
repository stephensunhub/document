# HashMap底层实现原理

数据结构: 数组 + 链表(1.8红黑树)

Key不可重复

无序

默认容量 16

默认负载因子 0.75, 就是说当size到达12时, 会发生扩容, 扩容为原来的两倍

允许一个null key, null value会被覆盖

默认链表长度大于8, 结构转为红黑树

自定义类的对象如果作为key, 必须重写hashcode和equals



# 影响HashMap性能的重要参数



# HashMap扩容



# 为什么HashMap的底层数组长度为何总是2的n次方



