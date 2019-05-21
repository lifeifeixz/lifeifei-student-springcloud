package org.lifeifei.fedis.fedisspringbootstarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "redis")
public class RedisConfig {
    private String hostName;
    private String userName;
    private String passWord;
    private Integer dataBase;


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getDataBase() {
        return dataBase;
    }

    public void setDataBase(Integer dataBase) {
        this.dataBase = dataBase;
    }
}
