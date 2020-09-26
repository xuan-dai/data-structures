package com.gorilla.data.structures.queue;

/**
 * 队列
 * @author xuan
 * @date 2020/09/26
 **/
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    // 入队
    void enqueue(E e);

    // 出队
    E dequeue();

    // 获取对首元素∂
    E getFront();
}
