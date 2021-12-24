package com.qw4wer.spring.cloud.nacos.examples.common.data.pojo;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Builder;
        import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * 
 *
 */

@Data
@Accessors(chain = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;
	/*
		
	*/	
	private Long id;
	/*
		
	*/	
	private String userName;
	/*
		
	*/	
	private String realName;
	/*
		
	*/	
	private String password;





}
