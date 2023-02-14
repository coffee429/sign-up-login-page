package com.blackhoodie.controller.user;

import com.blackhoodie.constant.ErrorEnum;
import com.blackhoodie.exception.ErrorResponse;
import com.blackhoodie.model.Account;
import com.blackhoodie.exception.ErrorException;
import com.blackhoodie.model.User;
import com.blackhoodie.repository.UserRepository;
import com.blackhoodie.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class UserController implements UserInterface{

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public Boolean login(Account accountInfo) {
        return false;
    }

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(SignUpRequest req) throws ErrorException {
        try {
            if(!userRepository.findByEmail(req.getEmail()).isPresent()) {
                User newUser = new User(
                        req.getName(),
                        req.getGender(),
                        req.getPhoneNumber(),
                        req.getEmail()
                );
                userRepository.save(newUser);
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            } else {
                throw new ErrorException("Email already register");
            }
        } catch (ErrorException e) {
            String errorCode = ErrorEnum.ERR1.toString();
            ErrorResponse err = new ErrorResponse(errorCode, e.getMessage());
            throw new ErrorException(err.toString());
        }
    }
}
