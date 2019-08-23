package com.lifeifei.springcloud.starter.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author feifei.li
 */
@ConfigurationProperties(prefix = "knife")
public class KnifeProperty {
    private String enable;
    private String type;

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
