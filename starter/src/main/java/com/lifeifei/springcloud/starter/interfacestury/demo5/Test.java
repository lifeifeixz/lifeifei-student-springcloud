package com.lifeifei.springcloud.starter.interfacestury.demo5;

/**
 * @author feifei.li
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Galaxy11("中国电信", "18914913629");
        phone.about();
        FeaturePhone featurePhone = new HuaWeiP20("中国移动", "18914913629");
        featurePhone.about();
    }
}
