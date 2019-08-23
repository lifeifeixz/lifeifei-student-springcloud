package com.lifeifei.springcloud.starter.interfacestury.demo5;

/**
 * @author feifei.li
 */
public class HuaWeiP20 extends AbstractSmartPhone implements HaWei {

    public HuaWeiP20(String operators, String phoneNumber) {
        super(operators, phoneNumber);
    }

    @Override
    public Object nfc() {
        System.out.println("卡号5505，余额:￥39.5");
        return null;
    }

    @Override
    public void playMusic(String musicName) {
        System.out.println("music:" + musicName);
    }

    @Override
    public void call(String phoneNumber) {
        System.out.println("呼叫中:" + phoneNumber);
    }

    @Override
    public void playVedio(String name) {
        System.out.println("电影:" + name);
    }

    @Override
    public void wifi() {
        System.out.println("中国电信:¬￢▔");
    }

    @Override
    public boolean gestureUnlock(String gestureInfo) {
        return "1".equals(gestureInfo);
    }
}
