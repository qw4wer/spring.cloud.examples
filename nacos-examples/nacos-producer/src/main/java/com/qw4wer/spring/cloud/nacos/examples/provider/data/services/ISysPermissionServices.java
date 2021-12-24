package com.qw4wer.spring.cloud.nacos.examples.provider.data.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysPermission;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysPermissionCond;

@Transactional
public interface ISysPermissionServices{

 	/**
     * 新增SysPermission
     * @param sysPermission
     * @throws RuntimeException
     */
	void addSysPermission(SysPermission sysPermission) throws RuntimeException;
	
    /**
     * 删除一条SysPermission
     * @param id 主键
     * @throws RuntimeException
     */
	void deleteSysPermission(int id) throws RuntimeException;

 	/**
     * 修改一条SysPermission
     * @param sysPermission
     * @throws RuntimeException
     */
	void updateSysPermission(SysPermission sysPermission) throws RuntimeException;

	/**
     * 查找一条SysPermission
     * @param id 主键
     * @return SysPermission
     * @throws RuntimeException
     */
    SysPermission findSysPermissionById(int id) throws RuntimeException;
    
    /**
     * 分页查找SysPermission
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysPermission>findSysPermissionByPage(SysPermissionCond cond) throws RuntimeException;

    /**
     * 根据条件查找SysPermission
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    List<SysPermission>findSysPermissionByCond(SysPermissionCond cond) throws RuntimeException;

    /**
     * 批量插入SysPermission
     * @throws RuntimeException
     */
	void batchInsertSysPermission (List<SysPermission> sysPermissionList) throws RuntimeException;
}