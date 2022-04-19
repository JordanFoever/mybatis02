package com.softeem.mybatis.mapper;

import com.softeem.mybatis.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 插入用户
     * @param user
     * @return
     */
    boolean insert(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    boolean deleteById(long id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 查询所有
     * @return
     */
    List<User> selectAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User selectById(long id);
}
