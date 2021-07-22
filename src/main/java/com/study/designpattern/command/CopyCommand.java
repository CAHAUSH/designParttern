package com.study.designpattern.command;

public class CopyCommand extends Command {
    Content c;

    public CopyCommand(Content c) {
        this.c = c;
    }

    @Override
    void doit() {
        c.msg = c.msg + c.msg;
    }

    @Override
    void undo() {
        c.msg = c.msg.substring(0,c.msg.length()/2);
    }

    @Override
    void doCommand(CommandChain chain) {
        doit();
        System.out.println("复制内容之后："+c.msg);
        chain.doCommand();
        undo();
        System.out.println("撤销复制的内容之后："+c.msg);
    }
}
