package com.gorilla.data.structures.BST;

/**
 * 二分搜索树，不允许存在重复的节点值
 *
 * @author xuan
 * @date 2020/09/26
 **/
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }

        return node;
    }

    /**
     * 是否包含某元素
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node node) {
        if(node == null) {
            return;
        }
        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (node.e.compareTo(e) > 0) {
            contains(node.right, e);
        } else {
            contains(node.left, e);
        }
        return false;
    }
}
