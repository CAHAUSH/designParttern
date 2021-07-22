package com.study.designpattern.visitor.v1;
/**
 * 结构不变的情况下，动态改变对于内部元素的动作
 * 如果Computer的内部结构不是固定不变的，那么不适合使用visitor设计模式
 * 书本应用示例:抽象语法书，的语法检查
 * */
public class Computer {
    ComputerPart cpu=new CPU();
    ComputerPart memory = new Memory();
    ComputerPart board = new Board();
    void accept(Visitor v){
        cpu.accept(v);
        memory.accept(v);
        board.accept(v);
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        Visitor pVisitor = new PersonalVisitor();
        Visitor cVisitor = new CorpVisitor();
        computer.accept(pVisitor);
        System.out.println(pVisitor.getPrice());
        computer.accept(cVisitor);
        System.out.println(cVisitor.getPrice());
    }
}

abstract class ComputerPart{
    abstract void accept(Visitor v);
    abstract double getPrice();
}

class CPU extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitCPU(this);
    }

    @Override
    double getPrice() {
        return 500;
    }
}

class Memory extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitMemory(this);
    }

    @Override
    double getPrice() {
        return 300;
    }
}

class Board extends ComputerPart{

    @Override
    void accept(Visitor v) {
        v.visitBoard(this);
    }

    @Override
    double getPrice() {
        return 100;
    }
}

interface Visitor{
    void visitCPU(CPU cpu);

    void visitMemory(Memory m);

    void visitBoard(Board b);

    double getPrice();
}

class PersonalVisitor implements Visitor{
    double totalPrice = 0;
    @Override
    public void visitCPU(CPU cpu) {
        totalPrice+=cpu.getPrice()*0.9;
    }

    @Override
    public void visitMemory(Memory m) {
        totalPrice+=m.getPrice()*0.9;
    }

    @Override
    public void visitBoard(Board b) {
        totalPrice+=b.getPrice()*0.9;
    }

    @Override
    public double getPrice() {
        return totalPrice;
    }
}

class CorpVisitor implements Visitor{
    double totalPrice = 0;
    @Override
    public void visitCPU(CPU cpu) {
        totalPrice+=cpu.getPrice()*0.8;
    }

    @Override
    public void visitMemory(Memory m) {
        totalPrice+=m.getPrice()*0.8;
    }

    @Override
    public void visitBoard(Board b) {
        totalPrice+=b.getPrice()*0.8;
    }

    @Override
    public double getPrice() {
        return totalPrice;
    }
}