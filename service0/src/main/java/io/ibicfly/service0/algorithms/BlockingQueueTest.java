package io.ibicfly.service0.algorithms;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author :cyh
 * @CreateDate: 2018/10/31 9:45
 * @Description: 作用描述
 * 阻塞队列
 * 它实质上就是一种带有一点扭曲的 FIFO 数据结构。不是立即从队列中添加或者删除元素，线程执行操作阻塞，直到有空间或者元素可用。
 */
public class BlockingQueueTest {
//    一个由数组支持的有界队列。
    ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
//    一个由链接节点支持的可选有界队列。
    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
//    一个由优先级堆支持的无界优先级队列。
    PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
//    一个由优先级堆支持的、基于时间的调度队列。
    DelayQueue delayQueue = new DelayQueue();
}
