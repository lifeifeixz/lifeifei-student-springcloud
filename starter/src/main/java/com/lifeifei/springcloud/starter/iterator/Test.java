package com.lifeifei.springcloud.starter.iterator;

/**
 * @author feifei.li
 */
public class Test {
    public static void main(String[] args) {
        ConcreateMyAggregate aggregate = new ConcreateMyAggregate();
        aggregate.add("哈萨克斯坦");
        aggregate.add("巴基斯坦");
        aggregate.add("吉尔吉斯坦");
        aggregate.add("伯多维亚");

        DpIterator<String> iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
