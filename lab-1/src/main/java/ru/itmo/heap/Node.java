package ru.itmo.heap;

class Node {

    int element, sValue;

    // class has two parameters
    Node left, right;

    public Node(int element) {
        this(element, null, null);
    }


    public Node(int element, Node left, Node right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.sValue = 0;
    }
}