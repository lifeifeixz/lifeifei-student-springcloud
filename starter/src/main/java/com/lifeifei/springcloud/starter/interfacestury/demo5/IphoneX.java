package com.lifeifei.springcloud.starter.interfacestury.demo5;

/**
 * @author feifei.li
 */
public class IphoneX extends AbstractSmartPhone implements Iphone {

    public IphoneX(String operators, String phoneNumber) {
        super(operators, phoneNumber);
    }

    @Override
    public void appStore(String name) {

    }

    @Override
    public boolean faceId(Object faceInfo) {
        return false;
    }

    @Override
    public void wifi() {

    }

    @Override
    public void playMusic(String musicName) {

    }

    @Override
    public void playVedio(String vedioName) {

    }

    @Override
    public void call(String phoneNumber) {

    }

    @Override
    public boolean gestureUnlock(String gestureInfo) {
        return false;
    }
}
