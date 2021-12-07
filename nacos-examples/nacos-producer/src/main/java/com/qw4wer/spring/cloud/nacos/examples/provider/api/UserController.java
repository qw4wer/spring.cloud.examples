package com.qw4wer.spring.cloud.nacos.examples.provider.api;

import com.qw4wer.spring.cloud.nacos.examples.common.RestResult;
import com.qw4wer.spring.cloud.nacos.examples.common.data.pojo.User;
import com.qw4wer.spring.cloud.nacos.examples.common.data.validation.Groups;
import com.qw4wer.spring.cloud.nacos.examples.provider.data.services.IUserServices;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    final IUserServices userServices;

    public UserController(IUserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping("/getUserById")
    @ResponseBody
    public RestResult<User> getUserById(Integer id) {
        User userById = userServices.findUserById(id);
        return RestResult.success(userById);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public RestResult addUser(@Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return this.getMessage(bindingResult);
        }
        userServices.addUser(user);
        return RestResult.success();
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
