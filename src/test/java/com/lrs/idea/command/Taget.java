package com.lrs.idea.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Taget {

    private static final Logger log = LoggerFactory.getLogger(Taget.class);

    private Size size;

    private Visbility visbility;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Visbility getVisbility() {
        return visbility;
    }

    public void setVisbility(Visbility visbility) {
        this.visbility = visbility;
    }

    @Override
    public abstract String toString() ;

    /**
     * print status
     */
    public void printStatus(){
        log.info("{},[size={}] [visbility={}]",this,size,visbility);
    }
}
