package com.blackhoodie.controller.login;

import com.blackhoodie.model.Login;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class LoginController implements LoginInterface{

    @PostMapping("/login")
    public Boolean login(Login loginInfo) {
        return false;
    }
}
