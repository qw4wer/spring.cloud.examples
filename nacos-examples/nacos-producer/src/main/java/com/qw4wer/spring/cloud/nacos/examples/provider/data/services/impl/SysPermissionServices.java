
package com.qw4wer.spring.cloud.nacos.examples.provider.data.services.impl;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysPermission;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysPermissionCond;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master.ISysPermissionMapper;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.services.ISysPermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("sysPermissionServices")
public class SysPermissionServices implements ISysPermissionServices {

	@Autowired
	ISysPermissionMapper sysPermissionMapper;

 	/**
     * 新增SysPermission
     * @param sysPermission
     * @throws RuntimeException
     */
	public void addSysPermission(SysPermission sysPermission) throws RuntimeException{
		sysPermissionMapper.addSysPermission(sysPermission);
	}
	
    /**
     * 删除一条SysPermission
     * @param id 主键
     * @throws RuntimeException
     */
	public void deleteSysPermission(int id) throws RuntimeException{
		sysPermissionMapper.deleteSysPermission(id);
	}

 	/**
     * 修改一条SysPermission
     * @param sysPermission
     * @throws RuntimeException
     */
	public void updateSysPermission(SysPermission sysPermission) throws RuntimeException{
		sysPermissionMapper.updateSysPermission(sysPermission);
	}

	/**
     * 查找一条SysPermission
     * @param id 主键
     * @return SysPermission
     * @throws RuntimeException
     */
    public SysPermission findSysPermissionById(int id) throws RuntimeException{
    	return sysPermissionMapper.findSysPermissionById(id);
    }
    
    /**
     * 分页查找SysPermission
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    public List<SysPermission>findSysPermissionByPage(SysPermissionCond cond) throws RuntimeException{
    	return sysPermissionMapper.findSysPermissionByPage(cond);
    }

    /**
     * 根据条件查找SysPermission
     * @param cond
     * @return 
     * @throws RuntimeException
     */
    public List<SysPermission>findSysPermissionByCond(SysPermissionCond cond) throws RuntimeException{
    	return sysPermissionMapper.findSysPermissionByCond(cond);
    }

    /**
     * 批量插入SysPermission
     * @throws RuntimeException
     */
	public void batchInsertSysPermission (List<SysPermission> sysPermissionList) throws RuntimeException{
	    sysPermissionMapper.batchInsertSysPermission(sysPermissionList);
	}
}