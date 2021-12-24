package com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master;

import java.util.List;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUser;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUserCond;

public interface ISysUserMapper{

 	/**
     * 新增SysUser
     * @param sysUser
     * @throws RuntimeException
     */
	void addSysUser(SysUser sysUser) throws RuntimeException;
	
    /**
     * 删除一条SysUser
     * @param id 主键
     * @throws RuntimeException
     */
	void deleteSysUser(int id) throws RuntimeException;

 	/**
     * 修改一条SysUser
     * @param sysUser
     * @throws RuntimeException
     */
	void updateSysUser(SysUser sysUser) throws RuntimeException;

	/**
     * 查找一条SysUser
     * @param id 主键
     * @return SysUser
     * @throws RuntimeException
     */
    SysUser findSysUserById(int id) throws RuntimeException;
    
    /**
     * 分页查找SysUser
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysUser>findSysUserByPage(SysUserCond cond) throws RuntimeException;

    /**
     * 根据条件查找SysUser
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysUser> findSysUserByCond(SysUserCond cond) throws RuntimeException;

    /**
     * 批量插入SysUser
     * @throws RuntimeException
     */
	void batchInsertSysUser (List<SysUser> sysUserList) throws RuntimeException;
}