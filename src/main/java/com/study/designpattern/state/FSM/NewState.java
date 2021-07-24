package com.study.designpattern.state.FSM;

public class NewState extends ThreadState_{
    Thread_ thread;

    public NewState(Thread_ thread) {
        this.thread = thread;
    }

    @Override
    void move(Action action) {
        if(action.msg=="start"){
            thread.state = new RunningState(thread);
        }
    }

    @Override
    void run() {

    }
}
