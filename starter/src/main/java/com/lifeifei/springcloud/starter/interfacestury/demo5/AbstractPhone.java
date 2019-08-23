package com.lifeifei.springcloud.starter.interfacestury.demo5;

/**
 * @author feifei.li
 */
public class AbstractPhone implements Phone {
    protected String operators;
    protected String PhoneNumber;

    public AbstractPhone(String operators, String phoneNumber) {
        PhoneNumber = phoneNumber;
        this.operators = operators;
    }

    @Override
    public void call(String phoneNumber) {
        System.out.println("呼叫中:" + phoneNumber);
    }

    @Override
    public Object about() {
        System.out.println(operators + " " + PhoneNumber);
        return operators + " " + PhoneNumber;
    }
}
