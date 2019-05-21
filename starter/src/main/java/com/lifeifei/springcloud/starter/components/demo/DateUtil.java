package com.lifeifei.springcloud.starter.components.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public String current() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
