package com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master;

import java.util.List;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUserRole;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUserRoleCond;

public interface ISysUserRoleMapper{

 	/**
     * 新增SysUserRole
     * @param sysUserRole
     * @throws RuntimeException
     */
	void addSysUserRole(SysUserRole sysUserRole) throws RuntimeException;
	
    /**
     * 删除一条SysUserRole
     * @param id 主键
     * @throws RuntimeException
     */
	void deleteSysUserRole(int id) throws RuntimeException;

 	/**
     * 修改一条SysUserRole
     * @param sysUserRole
     * @throws RuntimeException
     */
	void updateSysUserRole(SysUserRole sysUserRole) throws RuntimeException;

	/**
     * 查找一条SysUserRole
     * @param id 主键
     * @return SysUserRole
     * @throws RuntimeException
     */
    SysUserRole findSysUserRoleById(int id) throws RuntimeException;
    
    /**
     * 分页查找SysUserRole
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysUserRole>findSysUserRoleByPage(SysUserRoleCond cond) throws RuntimeException;

    /**
     * 根据条件查找SysUserRole
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysUserRole> findSysUserRoleByCond(SysUserRoleCond cond) throws RuntimeException;

    /**
     * 批量插入SysUserRole
     * @throws RuntimeException
     */
	void batchInsertSysUserRole (List<SysUserRole> sysUserRoleList) throws RuntimeException;
}