package com.study.designpattern.iterator.v1;

public class LinkList_ implements Collection_{
    public static void main(String[] args) {
        Collection_ collection_ = new LinkList_();
        for (int i = 0; i < 15; i++) {
            collection_.add("link"+i);
        }
        System.out.println("linklist size:"+collection_.size());
    }
    private Node head = null;
    private Node tail = null;
    private int size = 0;
    @Override
    public void add(Object o) {
        if(head == null){
            Node node = new Node();
            node.add(o);
            head = node;
            tail = node;

        }else{
            Node node = new Node();
            node.add(o);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    class Node{
        Object object = null;
        Node next = null;
        void add(Object o){
            object = o;
        }

        public Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }
}
