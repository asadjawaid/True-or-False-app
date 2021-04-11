package com.example.trueorfalsequiz;

public class Questions {
    private int answerId;
    private boolean isTrue;

    public Questions(int answerId, boolean isTrue) {
        this.answerId = answerId;
        this.isTrue = isTrue;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
