package com.study.designpattern.command;

public class DeleteCommand extends Command{
    Content c;
    String delete;

    public DeleteCommand(Content c) {
        this.c = c;
    }

    @Override
    void doit() {
        delete = c.msg.substring(0,5);
        c.msg = c.msg.substring(5,c.msg.length());
    }

    @Override
    void undo() {
        c.msg = delete + c.msg;
    }

    @Override
    void doCommand(CommandChain chain) {
        doit();
        System.out.println("删除5个字符之后："+c.msg);
        chain.doCommand();
        undo();
        System.out.println("撤销5个字符之后："+c.msg);
    }
}
