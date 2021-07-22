package com.study.designpattern.command;

public class InsertCommand extends Command {
    Content c;
    String strToInsert = "http://test.com";

    public InsertCommand(Content c) {
        this.c = c;
    }

    @Override
    void doit() {
        c.msg = c.msg + strToInsert;
    }

    @Override
    void undo() {
        c.msg = c.msg.substring(0 ,c.msg.length()-strToInsert.length());
    }

    @Override
    void doCommand(CommandChain chain) {
        doit();
        System.out.println("插入之后："+c.msg);
        chain.doCommand();
        undo();
        System.out.println("撤销插入之后："+c.msg);
    }
}
