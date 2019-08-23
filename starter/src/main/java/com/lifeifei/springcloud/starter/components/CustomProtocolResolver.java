package com.lifeifei.springcloud.starter.components;

import org.springframework.core.io.*;

import java.io.IOException;

/**
 * @author feifei.li
 */
public class CustomProtocolResolver implements ProtocolResolver {

    private static String CLASS_PATH_PRE = "classpath:";

    @Override
    public Resource resolve(String s, ResourceLoader resourceLoader) {
        if (s.startsWith(CLASS_PATH_PRE)) {
            System.out.println(s);
            return new ClassPathResource(s.substring(CLASS_PATH_PRE.length()));
        }
        return null;
    }

    public static void main(String[] args) {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        defaultResourceLoader.getProtocolResolvers()
                .add(new CustomProtocolResolver());
        try {
            System.out.println(defaultResourceLoader.getResource("classpath:smart-context.xml").getURI().toURL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
