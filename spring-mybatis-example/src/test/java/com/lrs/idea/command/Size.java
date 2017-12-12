package com.lrs.idea.command;

public enum Size {
    SMALL("small"),NORMAL("normal");

    private String title;

    Size(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return this.title;
    }
}
