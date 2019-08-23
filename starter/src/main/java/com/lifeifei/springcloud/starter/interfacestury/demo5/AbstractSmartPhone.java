package com.lifeifei.springcloud.starter.interfacestury.demo5;

/**
 * @author feifei.li
 */
public abstract class AbstractSmartPhone extends AbstractFeaturePhone implements SmartPhone {

    public AbstractSmartPhone(String operators, String phoneNumber) {
        super(operators, phoneNumber);
    }

    @Override
    public void wifi() {
        System.out.println(operators + ":¬￢▔");
    }

    @Override
    public boolean gestureUnlock(String gestureInfo) {
        return "1".equals(gestureInfo);
    }


}
