package com.blackhoodie.controller.user;

import com.blackhoodie.exception.ErrorException;
import com.blackhoodie.model.User;
import com.blackhoodie.request.LoginRequest;
import com.blackhoodie.request.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserInterface {

    public ResponseEntity<User> login(@RequestBody LoginRequest req) throws ErrorException;

    public ResponseEntity<Boolean> signup(@RequestBody SignUpRequest req) throws ErrorException;
}
