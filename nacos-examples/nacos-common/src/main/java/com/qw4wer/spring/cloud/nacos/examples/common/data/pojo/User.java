package com.qw4wer.spring.cloud.nacos.examples.common.data.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 *
 */

@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /*

     */
    private Long id;
    /*

     */
    @NotNull(message = "password不能为空")
    private String password;
    /*

     */
    @NotNull(message = "realName不能为空")
    private String realName;
    /*

     */
    @NotNull(message = "userName不能为空")
    private String userName;


}
