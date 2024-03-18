package ru.itmo.heap;

public class LeftHeap {

    private Node head;

    public LeftHeap() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void merge(LeftHeap rhs) {
        if (this == rhs) {
            return;
        }

        head = merge(head, rhs.head);
        rhs.head = null;
    }

    public Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.element > b.element) {

            Node temp = a;
            a = b;
            b = temp;
        }

        a.right = merge(a.right, b);

        if (a.left == null) {
            a.left = a.right;
            a.right = null;
        }

        else {

            if (a.left.sValue < a.right.sValue) {
                Node temp = a.left;
                a.left = a.right;
                a.right = temp;
            }

            a.sValue = a.right.sValue + 1;
        }

        return a;
    }

    public void insert(int a) {
        head = merge(new Node(a), head);
    }

    public int del() {
        if (isEmpty()) {
            return -1;
        }

        int min = head.element;

        head = merge(head.left, head.right);
        return min;
    }

    // Function order
    // will print the starting and ending points in order.
    public void order() {
        order(head);
        System.out.println();
    }

    // Function order with Node r
    // If r not equal to r
    // It prints all the elements iterating from order left
    // to right
    private void order(Node r) {
        if (r != null) {
            order(r.left);
            System.out.print(r.element + " ");
            order(r.right);
        }
    }
}
