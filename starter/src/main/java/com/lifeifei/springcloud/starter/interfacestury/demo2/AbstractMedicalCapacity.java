package com.lifeifei.springcloud.starter.interfacestury.demo2;

public class AbstractMedicalCapacity implements MedicalCapacity {
    @Override
    public void haveAnOperation() {
        System.out.println("做手术...");
    }

    @Override
    public String inspect() {
        return "检查...";
    }

    @Override
    public String diacrisis() {
        return "您的诊断结果是:妻管严!";
    }

    @Override
    public String xRays() {
        return null;
    }

    @Override
    public String electrocardiogram() {
        return null;
    }

    @Override
    public void injection(String medicine) {

    }
}
