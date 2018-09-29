package com.algorithms.btree.entities;

public class BinaryTree {

    Node root;

    public void add(int value) {
        root = add(root, value);
    }

    private Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = add(current.left, value);
        } else if (value > current.value) {
            current.right = add(current.right, value);
        }

        return current;
    }

    public Integer closestCommonAncestor(int value1, int value2){
        Integer response = null;
        if (root != null && checkExistance(value1) && checkExistance(value2)) {
            response = closestCommonAncestor(root, value1, value2);
        }

        return  response;
    }

    private int closestCommonAncestor(Node current, int value1, int value2){
            if (current.value > value1 && current.value > value2){
                return closestCommonAncestor(current.left, value1, value2);
            }else if (current.value < value1 && current.value < value2){
                return closestCommonAncestor(current.right, value1, value2);
            }

        return current.value;
    }

    public boolean checkExistance(int value){
        boolean response = false;
        if (root != null){
            response = checkExistance(root, value);
        }

        return response;
    }

    private boolean checkExistance(Node current, int value){
        boolean response = false;
        if (current != null){
            if (current.value == value){
                response = true;
            }else if (current.value < value){
                response = checkExistance(current.right, value);
            }else if (current.value > value){
                response = checkExistance(current.left, value);
            }
        }

        return response;
    }

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
