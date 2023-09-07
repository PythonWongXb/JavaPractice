package org.example.generics;

public class LinkedStack<T> {
    private static class Node<U> {
        // 当前值
        U item;
        // 下一个节点
        Node<U> next;
        Node() {
            item = null;
            next = null;
        }
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }
        // 都空才为空
        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();
    public void push(T item) {
        top = new Node<>(item, top);
    }
    public T pop() {
        T item = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        for(String s : "s 1 2 3".split(" ")) {
            stack.push(s);
        }
        String s;
        while((s = stack.pop()) != null) {
            System.out.println(s);
        }
    }
}
