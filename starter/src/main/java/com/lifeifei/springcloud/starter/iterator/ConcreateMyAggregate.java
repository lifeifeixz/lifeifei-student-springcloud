package com.lifeifei.springcloud.starter.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feifei.li
 */
public class ConcreateMyAggregate {

    private List<String> list = new ArrayList<>(1);

    public void add(String o) {
        this.list.add(o);
    }

    public void remove(String o) {
        this.list.remove(o);
    }

    public DpIterator<String> iterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements DpIterator {
        private int cursor;

        @Override
        public void first() {
            cursor = 0;
        }

        @Override
        public void isLast() {

        }

        @Override
        public Object next() {
            if (hasNext()) {
                String val = list.get(cursor);
                cursor += 1;
                return val;
            } else {
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            return list.size() > cursor;
        }
    }
}
