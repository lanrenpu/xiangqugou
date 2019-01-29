package cn.etc.xqg.web.controller;

import cn.etc.xqg.domain.User;
import cn.etc.xqg.utils.AjaxResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody User user){
        if("admin".equals(user.getUsername()) && "123456".equals(user.getPassword()))
            return AjaxResult.me().setSuccess(true).setMessage("登录成功！");
        return AjaxResult.me().setSuccess(false).setMessage("用户名或密码错误！");
    }
}
