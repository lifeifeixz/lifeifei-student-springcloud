package org.flys.cg.builder;

import org.flys.cg.meta.Column;

/**
 * @author feifei.li
 */
public interface JavaCodeBuilder {

    String build(Column column);

    String build(String name, String type);

}
