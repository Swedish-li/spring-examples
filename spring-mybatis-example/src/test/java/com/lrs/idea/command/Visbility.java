package com.lrs.idea.command;


public enum  Visbility {
    VISIABLE("visiable"),INVISIABLE("invisiable");

    private String title;
   
    Visbility(String title){
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }
}
