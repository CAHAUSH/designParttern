package com.study.designpattern.iterator.v2;
/**
 * 容器与容器遍历 iterator设计模式
 * */
public class Main {
    public static void main(String[] args) {
        Collection_ list = new LinkList_();
        for (int i = 0; i < 15; i++) {
            list.add("link:"+i);
        }
        System.out.println("size:"+list.size());
        Iterator_ iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
