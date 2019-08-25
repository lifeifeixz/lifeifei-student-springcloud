package org.flys.cg.meta;

public interface PackageOrganizer {
    String SPOT=".";

    /**
     * 加入
     *
     * @param singleName
     * @param fullClassName
     */
    void join(String singleName, String fullClassName);

    /**
     * 获取全类名
     *
     * @param singleName
     * @return
     */
    String getFullClassName(String singleName);
}
