package com.xiaoliu.modules;

import com.xiaoliu.modules.factory.port.impl.CpuFactory;

/**
 *
 */
public class FactoryDemo {
    public static void main(String[] args){
        CpuFactory.getInstance().produce().showName();
    }
}
