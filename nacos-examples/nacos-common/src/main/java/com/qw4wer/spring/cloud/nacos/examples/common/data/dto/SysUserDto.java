package com.qw4wer.spring.cloud.nacos.examples.common.data.dto;

import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysPermission;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDto extends SysUser {

    private List<SysPermission> sysPermissionList;

}
