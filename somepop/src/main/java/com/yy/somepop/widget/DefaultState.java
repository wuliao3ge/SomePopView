package com.yy.somepop.widget;

/**
 * Created by ly on 2017/12/26.
 */

public enum DefaultState {
    CONFIRMONLEFT(0) ,
    CONFIRMONRIGHT(1),
    CONFIRMONLY(2);
    private int state;
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    DefaultState(int state)
    {
        this.state = state;
    }
}
