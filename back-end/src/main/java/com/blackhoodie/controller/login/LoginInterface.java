package com.blackhoodie.controller.login;

import com.blackhoodie.model.Login;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface LoginInterface {

    public Boolean login(@RequestBody Login loginInfo);
}
