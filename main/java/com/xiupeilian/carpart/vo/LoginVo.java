package com.xiupeilian.carpart.vo;

import java.io.Serializable;

/**
 * @Description: 登录vo类
 * @Author: Tu Xu
 * @CreateDate: 2019/8/21 14:56
 * @Version: 1.0
 **/
public class LoginVo implements Serializable {

    private String loginName;
    private String password;
    private String validate;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
}
