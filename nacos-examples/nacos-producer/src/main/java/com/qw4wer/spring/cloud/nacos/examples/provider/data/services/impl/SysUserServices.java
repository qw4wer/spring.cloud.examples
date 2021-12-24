
package com.qw4wer.spring.cloud.nacos.examples.provider.data.services.impl;

import com.qw4wer.spring.cloud.nacos.examples.common.data.dto.SysUserDto;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysPermission;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUser;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUserCond;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master.ISysPermissionMapper;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.mapper.master.ISysUserMapper;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.services.ISysUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("sysUserServices")
public class SysUserServices implements ISysUserServices {

    @Autowired
    ISysUserMapper sysUserMapper;

    @Autowired
    ISysPermissionMapper sysPermissionMapper;

    /**
     * 新增SysUser
     *
     * @param sysUser
     * @throws RuntimeException
     */
    public void addSysUser(SysUser sysUser) throws RuntimeException {
        sysUserMapper.addSysUser(sysUser);
    }

    /**
     * 删除一条SysUser
     *
     * @param id 主键
     * @throws RuntimeException
     */
    public void deleteSysUser(int id) throws RuntimeException {
        sysUserMapper.deleteSysUser(id);
    }

    /**
     * 修改一条SysUser
     *
     * @param sysUser
     * @throws RuntimeException
     */
    public void updateSysUser(SysUser sysUser) throws RuntimeException {
        sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 查找一条SysUser
     *
     * @param id 主键
     * @return SysUser
     * @throws RuntimeException
     */
    public SysUser findSysUserById(int id) throws RuntimeException {
        return sysUserMapper.findSysUserById(id);
    }

    /**
     * 分页查找SysUser
     *
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<SysUser> findSysUserByPage(SysUserCond cond) throws RuntimeException {
        return sysUserMapper.findSysUserByPage(cond);
    }

    /**
     * 根据条件查找SysUser
     *
     * @param cond
     * @return
     * @throws RuntimeException
     */
    public List<SysUser> findSysUserByCond(SysUserCond cond) throws RuntimeException {
        return sysUserMapper.findSysUserByCond(cond);
    }

    /**
     * 批量插入SysUser
     *
     * @throws RuntimeException
     */
    public void batchInsertSysUser(List<SysUser> sysUserList) throws RuntimeException {
        sysUserMapper.batchInsertSysUser(sysUserList);
    }

    @Override
    public SysUserDto login(String username) throws RuntimeException {
        Optional<SysUser> first = sysUserMapper.findSysUserByCond(SysUserCond.builder().userName(username).build()).stream().findFirst();
        if (first.isPresent()) {
            SysUser sysUser = first.get();

            List<SysPermission> permissionByUserId = sysPermissionMapper.findPermissionByUserId(sysUser.getId());

            SysUserDto sysUserDto = SysUserDto.builder()
                    .userName(sysUser.getUserName()).password(sysUser.getPassword()).id(sysUser.getId())
                    .sysPermissionList(permissionByUserId).build();
            sysUserDto.setSysPermissionList(permissionByUserId);
            return sysUserDto;
        }
        return null;
    }
}