package com.lifeifei.springcloud.starter.interfacestury.demo5;

/**
 * @author feifei.li
 */
public class Galaxy11 extends AbstractSmartPhone implements SamsSung {
    public Galaxy11(String operators, String phoneNumber) {
        super(operators, phoneNumber);
    }

    @Override
    public void foldingScreen() {
        System.out.println("折叠中...");
    }
}
