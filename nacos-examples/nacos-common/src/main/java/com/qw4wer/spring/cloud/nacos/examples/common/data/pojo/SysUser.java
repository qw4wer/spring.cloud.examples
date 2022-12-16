package com.qw4wer.spring.cloud.nacos.examples.common.data.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


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
	public interface A{};

	private static final long serialVersionUID = 1L;
	/*
		
	*/
	private Long id;
	/*
		
	*/
	@NotNull(groups = A.class,message = "userName 不能为空")
	private String userName;
	/*
		
	*/	
	private String realName;
	/*
		
	*/	
	private String password;





}
