package org.flys.cg.builder;

import org.flys.cg.Column;

public interface JavaDataMethodBuilderInterface {

    String buildGet(Column column);

    String buildGet(String name,String type);

    String buildSet(Column column);

    String buildSet(String name,String type);
}
