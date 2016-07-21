package com.xiaoliu.modules.factory.port.impl;

import com.xiaoliu.modules.factory.port.IProduct;

/**
 * Cpu
 *
 * @author Administrator
 * @date 2016/7/21-14:09
 * @desc Cpu
 */
public class Cpu implements IProduct {
    @Override
    public void showName() {
        System.out.print("i'm a cpu.");
    }
}
