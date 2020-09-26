package com.gorilla.data.structures.stack;

/**
 * 栈
 * @author xuan
 * @date 2020/09/26
 **/
public interface Stack<E> {
    // 出栈
    E pop();

    // 查看栈底元素
    E peek();

    int getSize();

    boolean isEmpty();

    // 入栈
    void push(E e);
}
