package com.study.designpattern.command;

/**
 * Command模式  封装命令，结合cor设计模式，可以实现undo的功能
 * 又叫 Action , Transaction
 * */
public class Main {
    public static void main(String[] args) {
        Content c = new Content();
        Command copyCommand = new CopyCommand(c);
        /*copyCommand.doit();
        System.out.println(c.msg);
        copyCommand.undo();
        System.out.println(c.msg);*/
        Command deleteCommand = new DeleteCommand(c);
        /*deleteCommand.doit();System.out.println(c.msg);
        deleteCommand.undo();System.out.println(c.msg);*/
        Command insertCommand = new InsertCommand(c);
        /*insertCommand.doit();System.out.println(c.msg);
        insertCommand.undo();System.out.println(c.msg);*/

        //与责任链模式组合，实现多个undo操作
        CommandChain chain = new CommandChain();
        chain.add(insertCommand);
        chain.add(deleteCommand);
        chain.add(copyCommand);
        System.out.println("原始字符："+c.msg);
        chain.doCommand();
        System.out.println("撤销所有操作："+c.msg);
    }
}
