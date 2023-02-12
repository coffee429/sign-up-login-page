package com.blackhoodie.controller.user;

import com.blackhoodie.model.Account;
import com.blackhoodie.request.SignUpRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserInterface {

    public Boolean login(@RequestBody Account accountInfo);

    public Boolean signup(@RequestBody SignUpRequest req);
}
