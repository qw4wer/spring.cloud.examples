
package com.qw4wer.spring.cloud.nacos.examples.provider.data.services.impl;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysRole;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysRoleCond;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master.ISysRoleMapper;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.services.ISysRoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("sysRoleServices")
public class SysRoleServices implements ISysRoleServices {

	@Autowired
	ISysRoleMapper sysRoleMapper;

 	/**
     * 新增SysRole
     * @param sysRole
     * @throws RuntimeException
     */
	public void addSysRole(SysRole sysRole) throws RuntimeException{
		sysRoleMapper.addSysRole(sysRole);
	}
	
    /**
     * 删除一条SysRole
     * @param id 主键
     * @throws RuntimeException
     */
	public void deleteSysRole(int id) throws RuntimeException{
		sysRoleMapper.deleteSysRole(id);
	}

 	/**
     * 修改一条SysRole
     * @param sysRole
     * @throws RuntimeException
     */
	public void updateSysRole(SysRole sysRole) throws RuntimeException{
		sysRoleMapper.updateSysRole(sysRole);
	}

	/**
     * 查找一条SysRole
     * @param id 主键
     * @return SysRole
     * @throws RuntimeException
     */
    public SysRole findSysRoleById(int id) throws RuntimeException{
    	return sysRoleMapper.findSysRoleById(id);
    }
    
    /**
     * 分页查找SysRole
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    public List<SysRole>findSysRoleByPage(SysRoleCond cond) throws RuntimeException{
    	return sysRoleMapper.findSysRoleByPage(cond);
    }

    /**
     * 根据条件查找SysRole
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    public List<SysRole>findSysRoleByCond(SysRoleCond cond) throws RuntimeException{
    	return sysRoleMapper.findSysRoleByCond(cond);
    }

    /**
     * 批量插入SysRole
     * @throws RuntimeException
     */
	public void batchInsertSysRole (List<SysRole> sysRoleList) throws RuntimeException{
	    sysRoleMapper.batchInsertSysRole(sysRoleList);
	}
}