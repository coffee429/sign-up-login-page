package com.blackhoodie.controller.login;

import com.blackhoodie.model.Login;
import com.blackhoodie.model.User;
import com.blackhoodie.request.SignUpRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface LoginInterface {

    public Boolean login(@RequestBody Login loginInfo);

    public Boolean signup(@RequestBody SignUpRequest req);
}
