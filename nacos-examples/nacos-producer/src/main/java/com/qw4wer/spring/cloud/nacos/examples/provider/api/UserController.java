package com.qw4wer.spring.cloud.nacos.examples.provider.api;

import com.qw4wer.spring.cloud.nacos.examples.common.RestResult;
import com.qw4wer.spring.cloud.nacos.examples.common.data.dto.SysUserDto;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.SysUser;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.services.ISysUserServices;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    final ISysUserServices sysUserServices;

    public UserController(ISysUserServices sysUserServices) {
        this.sysUserServices = sysUserServices;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public RestResult<SysUser> getUserById(Integer id) {
        SysUser userById = sysUserServices.findSysUserById(id);
        return RestResult.success(userById);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public RestResult addUser(@RequestBody @Validated SysUser user, BindingResult bindingResult) {
        System.out.println(user);
        if (bindingResult.hasErrors()) {
            return this.getMessage(bindingResult);
        }
        sysUserServices.addSysUser(user);
        return RestResult.success(user);
    }


    @RequestMapping("/login")
    @ResponseBody
    public RestResult login(String username) {
        SysUserDto login = sysUserServices.login(username);
        return RestResult.success(login);
    }


    protected RestResult getMessage(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        for (ObjectError allError : allErrors) {
            stringBuilder.append(allError.getDefaultMessage());
        }
        return RestResult.error(stringBuilder.toString());
    }
}
