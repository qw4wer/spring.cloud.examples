package com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master;

import java.util.List;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysRole;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysRoleCond;

public interface ISysRoleMapper{

 	/**
     * 新增SysRole
     * @param sysRole
     * @throws RuntimeException
     */
	void addSysRole(SysRole sysRole) throws RuntimeException;
	
    /**
     * 删除一条SysRole
     * @param id 主键
     * @throws RuntimeException
     */
	void deleteSysRole(int id) throws RuntimeException;

 	/**
     * 修改一条SysRole
     * @param sysRole
     * @throws RuntimeException
     */
	void updateSysRole(SysRole sysRole) throws RuntimeException;

	/**
     * 查找一条SysRole
     * @param id 主键
     * @return SysRole
     * @throws RuntimeException
     */
    SysRole findSysRoleById(int id) throws RuntimeException;
    
    /**
     * 分页查找SysRole
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysRole>findSysRoleByPage(SysRoleCond cond) throws RuntimeException;

    /**
     * 根据条件查找SysRole
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysRole> findSysRoleByCond(SysRoleCond cond) throws RuntimeException;

    /**
     * 批量插入SysRole
     * @throws RuntimeException
     */
	void batchInsertSysRole (List<SysRole> sysRoleList) throws RuntimeException;
}