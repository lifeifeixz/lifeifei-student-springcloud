package com.demo3;

/**
 * @author feifei.li
 */
public class Test {

    public static void main(String[] args) {
        Monkey monkey = new SixEarsMonkey();

        monkey.eatBananas();
        SpellsMonkey spellsMonkey = new SunWuKong();

        Object deformation = spellsMonkey.deformation("牛魔王");
        System.out.println(deformation);
    }
}
