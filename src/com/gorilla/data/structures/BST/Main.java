package com.gorilla.data.structures.BST;

/**
 * @author xuan
 * @date 2020/09/26
 **/
public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 3, 6, 8, 4, 2};

        BST<Integer> tree = new BST<>();

        for (int num : nums) {
            tree.add(num);
        }

        tree.preOrder();
        System.out.println("\n");
        tree.midOrder();
        System.out.println("\n");
        tree.postOrder();
    }
}
