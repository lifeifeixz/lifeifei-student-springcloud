package com.lifeifei.springcloud.starter.interfacestury.demo2;

/**
 * @author feifei.li
 */
public interface MedicalCapacity extends MedicalEquipment, Nursing {
    void haveAnOperation();

    String inspect();

    String diacrisis();
}
