package com.study.designpattern.command;

abstract public class Command {
    abstract void doit();
    abstract void undo();
    abstract void doCommand(CommandChain chain);
}
