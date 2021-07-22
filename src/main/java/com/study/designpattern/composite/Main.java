package com.study.designpattern.composite;

import java.util.ArrayList;
import java.util.List;
/**
* 组合模式用于操作树状结构的数据
* */

public class Main {
    public static void main(String[] args) {
        Node root = new BranchNode("root");
    }
}

abstract class Node{
    abstract void print();
}

class LeafNode extends Node{
    String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    void print() {

    }
}

class BranchNode extends Node{
    List<Node> childNodes = new ArrayList<>();
    String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    void print() {

    }

    void addNode(Node node){
        childNodes.add(node);
    }
}
