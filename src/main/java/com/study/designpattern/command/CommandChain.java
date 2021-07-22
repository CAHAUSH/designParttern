package com.study.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class CommandChain {
    List<Command> lists = new ArrayList<>();
    int offset = 0;

    void add(Command command){
        lists.add(command);
    }

    void doCommand(){
        if(offset<lists.size()){
            Command c = lists.get(offset);
            offset++;
            c.doCommand(this);
        }
    }
}
