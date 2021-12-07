
package com.qw4wer.spring.cloud.nacos.examples.provider.data.services.impl;

import com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master.IUserMapper;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.User;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.UserCond;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.services.IUserServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServices")
public class UserServices implements IUserServices {

    final IUserMapper userMapper;

    public UserServices(IUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 新增User
     *
     * @param user
     * @throws RuntimeException
     */
    public void addUser(User user) throws RuntimeException {
        userMapper.addUser(user);
    }

    /**
     * 删除一条User
     *
     * @param id 主键
     * @throws RuntimeException
     */
    public void deleteUser(int id) throws RuntimeException {
        userMapper.deleteUser(id);
    }

    /**
     * 修改一条User
     *
     * @param user
     * @throws RuntimeException
     */
    public void updateUser(User user) throws RuntimeException {
        userMapper.updateUser(user);
    }

    /**
     * 查找一条User
     *
     * @param id 主键
     * @return User
     * @throws RuntimeException
     */
    public User findUserById(int id) throws RuntimeException {
        return userMapper.findUserById(id);
    }

    /**
     * 分页查找User
     *
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<User> findUserByPage(UserCond cond) throws RuntimeException {
        return userMapper.findUserByPage(cond);
    }

    /**
     * 根据条件查找User
     *
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<User> findUserByCond(UserCond cond) throws RuntimeException {
        return userMapper.findUserByCond(cond);
    }

    /**
     * 批量插入User
     *
     * @throws RuntimeException
     */
    public void batchInsertUser(List<User> userList) throws RuntimeException {
        userMapper.batchInsertUser(userList);
    }
}