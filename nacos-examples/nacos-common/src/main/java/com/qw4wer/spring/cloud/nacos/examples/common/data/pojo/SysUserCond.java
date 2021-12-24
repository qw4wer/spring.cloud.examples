package com.qw4wer.spring.cloud.nacos.examples.common.data.pojo;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;


/**
 *  查询类
 *
 */
@SuperBuilder
public class SysUserCond extends SysUser implements Serializable{
	private static final long serialVersionUID = 1L;

}
