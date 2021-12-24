
package com.qw4wer.spring.cloud.nacos.examples.provider.data.services.impl;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysRolePermission;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysRolePermissionCond;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master.ISysRolePermissionMapper;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.services.ISysRolePermissionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysRolePermissionServices")
public class SysRolePermissionServices implements ISysRolePermissionServices {

    @Autowired
    ISysRolePermissionMapper sysRolePermissionMapper;

    /**
     * 新增SysRolePermission
     *
     * @param sysRolePermission
     * @throws RuntimeException
     */
    public void addSysRolePermission(SysRolePermission sysRolePermission) throws RuntimeException {
        sysRolePermissionMapper.addSysRolePermission(sysRolePermission);
    }

    /**
     * 删除一条SysRolePermission
     *
     * @param id 主键
     * @throws RuntimeException
     */
    public void deleteSysRolePermission(int id) throws RuntimeException {
        sysRolePermissionMapper.deleteSysRolePermission(id);
    }

    /**
     * 修改一条SysRolePermission
     *
     * @param sysRolePermission
     * @throws RuntimeException
     */
    public void updateSysRolePermission(SysRolePermission sysRolePermission) throws RuntimeException {
        sysRolePermissionMapper.updateSysRolePermission(sysRolePermission);
    }

    /**
     * 查找一条SysRolePermission
     *
     * @param id 主键
     * @return SysRolePermission
     * @throws RuntimeException
     */
    public SysRolePermission findSysRolePermissionById(int id) throws RuntimeException {
        return sysRolePermissionMapper.findSysRolePermissionById(id);
    }

    /**
     * 分页查找SysRolePermission
     *
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<SysRolePermission> findSysRolePermissionByPage(SysRolePermissionCond cond) throws RuntimeException {
        return sysRolePermissionMapper.findSysRolePermissionByPage(cond);
    }

    /**
     * 根据条件查找SysRolePermission
     *
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<SysRolePermission> findSysRolePermissionByCond(SysRolePermissionCond cond) throws RuntimeException {
        return sysRolePermissionMapper.findSysRolePermissionByCond(cond);
    }

    /**
     * 批量插入SysRolePermission
     *
     * @throws RuntimeException
     */
    public void batchInsertSysRolePermission(List<SysRolePermission> sysRolePermissionList) throws RuntimeException {
        sysRolePermissionMapper.batchInsertSysRolePermission(sysRolePermissionList);
    }
}