package com.lifeifei.springcloud.starter;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupTest {
    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("https://ued.justech.com/v2/static/v1/js/plugins/zabuto_calendar/zabuto_calendar.js");
        Document document = connect.get();
        System.out.println(document.toString());
    }
}
