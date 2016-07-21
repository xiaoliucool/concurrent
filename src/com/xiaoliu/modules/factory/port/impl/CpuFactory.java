package com.xiaoliu.modules.factory.port.impl;

import com.xiaoliu.modules.factory.port.IFactory;
import com.xiaoliu.modules.factory.port.IProduct;

/**
 * CpuFactory
 *
 * @author Administrator
 * @date 2016/7/21-14:06
 * @desc cpu工厂
 */
public class CpuFactory implements IFactory {
    private static CpuFactory instance;
    private CpuFactory(){}
    public static CpuFactory getInstance(){
        if (null == instance){
            synchronized (CpuFactory.class){
                if (null == instance){
                    instance = new CpuFactory();
                }
            }
        }
        return instance;
    }
    @Override
    public IProduct produce() {
        return new Cpu();
    }
}
