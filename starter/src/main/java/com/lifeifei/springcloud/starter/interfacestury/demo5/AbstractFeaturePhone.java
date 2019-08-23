package com.lifeifei.springcloud.starter.interfacestury.demo5;

/**
 * @author feifei.li
 */
public abstract class AbstractFeaturePhone extends AbstractPhone implements FeaturePhone {
    public AbstractFeaturePhone(String operators, String phoneNumber) {
        super(operators,phoneNumber);
    }

    @Override
    public void playMusic(String musicName) {
        System.out.println("music:" + musicName);
    }

    @Override
    public void playVedio(String name) {
        System.out.println("电影:" + name);
    }
}
