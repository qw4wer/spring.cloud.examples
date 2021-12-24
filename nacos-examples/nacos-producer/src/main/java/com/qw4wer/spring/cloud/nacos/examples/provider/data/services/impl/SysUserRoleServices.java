
package com.qw4wer.spring.cloud.nacos.examples.provider.data.services.impl;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUserRole;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUserRoleCond;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master.ISysUserRoleMapper;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.services.ISysUserRoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserRoleServices")
public class SysUserRoleServices implements ISysUserRoleServices {

    @Autowired
    ISysUserRoleMapper sysUserRoleMapper;

    /**
     * 新增SysUserRole
     *
     * @param sysUserRole
     * @throws RuntimeException
     */
    public void addSysUserRole(SysUserRole sysUserRole) throws RuntimeException {
        sysUserRoleMapper.addSysUserRole(sysUserRole);
    }

    /**
     * 删除一条SysUserRole
     *
     * @param id 主键
     * @throws RuntimeException
     */
    public void deleteSysUserRole(int id) throws RuntimeException {
        sysUserRoleMapper.deleteSysUserRole(id);
    }

    /**
     * 修改一条SysUserRole
     *
     * @param sysUserRole
     * @throws RuntimeException
     */
    public void updateSysUserRole(SysUserRole sysUserRole) throws RuntimeException {
        sysUserRoleMapper.updateSysUserRole(sysUserRole);
    }

    /**
     * 查找一条SysUserRole
     *
     * @param id 主键
     * @return SysUserRole
     * @throws RuntimeException
     */
    public SysUserRole findSysUserRoleById(int id) throws RuntimeException {
        return sysUserRoleMapper.findSysUserRoleById(id);
    }

    /**
     * 分页查找SysUserRole
     *
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<SysUserRole> findSysUserRoleByPage(SysUserRoleCond cond) throws RuntimeException {
        return sysUserRoleMapper.findSysUserRoleByPage(cond);
    }

    /**
     * 根据条件查找SysUserRole
     *
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<SysUserRole> findSysUserRoleByCond(SysUserRoleCond cond) throws RuntimeException {
        return sysUserRoleMapper.findSysUserRoleByCond(cond);
    }

    /**
     * 批量插入SysUserRole
     *
     * @throws RuntimeException
     */
    public void batchInsertSysUserRole(List<SysUserRole> sysUserRoleList) throws RuntimeException {
        sysUserRoleMapper.batchInsertSysUserRole(sysUserRoleList);
    }
}