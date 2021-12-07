package com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.User;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.UserCond;

import java.util.List;


public interface IUserMapper{

 	/**
     * 新增User
     * @param user
     * @throws RuntimeException
     */
	void addUser(User user) throws RuntimeException;
	
    /**
     * 删除一条User
     * @param id 主键
     * @throws RuntimeException
     */
	void deleteUser(int id) throws RuntimeException;

 	/**
     * 修改一条User
     * @param user
     * @throws RuntimeException
     */
	void updateUser(User user) throws RuntimeException;

	/**
     * 查找一条User
     * @param id 主键
     * @return User
     * @throws RuntimeException
     */
    User findUserById(int id) throws RuntimeException;
    
    /**
     * 分页查找User
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<User>findUserByPage(UserCond cond) throws RuntimeException;

    /**
     * 根据条件查找User
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<User> findUserByCond(UserCond cond) throws RuntimeException;

    /**
     * 批量插入User
     * @throws RuntimeException
     */
	void batchInsertUser (List<User> userList) throws RuntimeException;
}