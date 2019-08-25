package org.flys.cg.builder;

public interface SqlBuilder {
    String buildFindAll();
    String buildFindOne();
    String buildDelete();
    String buildUpdate();
    String buildSave();
}
