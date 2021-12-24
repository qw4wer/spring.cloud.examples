package com.qw4wer.spring.cloud.nacos.examples.common.data.pojo;

import java.io.Serializable;


        import lombok.Builder;
        import lombok.Data;
        import lombok.experimental.Accessors;


/**
 * 
 *
 */

@Data
@Accessors(chain = true)
@Builder
public class SysRolePermission implements Serializable{
	private static final long serialVersionUID = 1L;
	/*
		
	*/	
	private Long id;
	/*
		
	*/	
	private Long roleId;
	/*
		
	*/	
	private Long permissionId;





}
