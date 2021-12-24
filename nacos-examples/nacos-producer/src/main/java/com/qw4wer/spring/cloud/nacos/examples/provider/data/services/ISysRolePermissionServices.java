package com.qw4wer.spring.cloud.nacos.examples.provider.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysRolePermission;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysRolePermissionCond;

@Transactional
public interface ISysRolePermissionServices{

 	/**
     * 新增SysRolePermission
     * @param sysRolePermission
     * @throws RuntimeException
     */
	void addSysRolePermission(SysRolePermission sysRolePermission) throws RuntimeException;
	
    /**
     * 删除一条SysRolePermission
     * @param id 主键
     * @throws RuntimeException
     */
	void deleteSysRolePermission(int id) throws RuntimeException;

 	/**
     * 修改一条SysRolePermission
     * @param sysRolePermission
     * @throws RuntimeException
     */
	void updateSysRolePermission(SysRolePermission sysRolePermission) throws RuntimeException;

	/**
     * 查找一条SysRolePermission
     * @param id 主键
     * @return SysRolePermission
     * @throws RuntimeException
     */
    SysRolePermission findSysRolePermissionById(int id) throws RuntimeException;
    
    /**
     * 分页查找SysRolePermission
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysRolePermission>findSysRolePermissionByPage(SysRolePermissionCond cond) throws RuntimeException;

    /**
     * 根据条件查找SysRolePermission
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysRolePermission>findSysRolePermissionByCond(SysRolePermissionCond cond) throws RuntimeException;

    /**
     * 批量插入SysRolePermission
     * @throws RuntimeException
     */
	void batchInsertSysRolePermission (List<SysRolePermission> sysRolePermissionList) throws RuntimeException;
}