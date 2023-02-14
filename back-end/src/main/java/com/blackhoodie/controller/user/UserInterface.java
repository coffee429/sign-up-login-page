package com.blackhoodie.controller.user;

import com.blackhoodie.exception.ErrorException;
import com.blackhoodie.model.Account;
import com.blackhoodie.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserInterface {

    public Boolean login(@RequestBody Account accountInfo);

    public ResponseEntity<Boolean> signup(@RequestBody SignUpRequest req) throws ErrorException;
}
