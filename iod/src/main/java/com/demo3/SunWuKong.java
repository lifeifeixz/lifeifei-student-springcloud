package com.demo3;

/**
 * @author feifei.li
 */
public class SunWuKong extends SixEarsMonkey implements SpellsMonkey {
    @Override
    public Object deformation(String target) {
        return "假的:" + target;
    }
}
