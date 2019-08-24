package org.flys.cg.template;

import org.apache.catalina.User;

public interface TemplateMapper {

    /**
     * 根据id删除记录
     *
     * @param id
     * @return
     */
    int deleteById(long id);

    /**
     * 添加记录
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 根据id修改记录
     *
     * @param id
     * @param user
     * @return
     */
    int updateById(long id, User user);

    /**
     * 根据id查询记录
     *
     * @param id
     * @return
     */
    User findById(long id);
}
