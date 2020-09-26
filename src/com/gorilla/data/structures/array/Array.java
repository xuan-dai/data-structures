package com.gorilla.data.structures.array;

/**
 * 数组
 *
 * @author xuan
 * @date 2020/09/26
 **/
public class Array<E> {

    private E[] data;
    private int size;

    public Array() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public void addLast(E e) {
        insert(size - 1, e);
    }

    public void addFirst(E e) {
        insert(0, e);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        E ret = data[index];
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = e;
        size++;
    }

    public boolean contains(E e) {
        for (E el : data) {
            if (el.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
}
