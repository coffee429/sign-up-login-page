package com.blackhoodie.controller.user;

import com.blackhoodie.constant.ErrorEnum;
import com.blackhoodie.exception.ErrorException;
import com.blackhoodie.exception.ErrorResponse;
import com.blackhoodie.model.Account;
import com.blackhoodie.model.User;
import com.blackhoodie.repository.AccountRepository;
import com.blackhoodie.repository.UserRepository;
import com.blackhoodie.request.LoginRequest;
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

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(LoginRequest req) throws ErrorException{
        try {
            if(accountRepository.findByEmailAndPassword(req.getEmail(), req.getPassword()).isPresent()) {
                User user = userRepository.findByEmail(req.getEmail()).get();
                return new ResponseEntity(user, HttpStatus.OK);
            } else {
                throw new ErrorException("Wrong email or password. Please try again");
            }
        } catch (ErrorException e) {
            String errorCode = ErrorEnum.ERR2.toString();
            ErrorResponse err = new ErrorResponse(errorCode, e.getMessage());
            throw new ErrorException(err.toString());
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
                // Save new user information
                userRepository.save(newUser);

                // Save email + password for the next login
                Account newAccount = new Account(req.getEmail(), req.getPassword());
                accountRepository.save(newAccount);

                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            } else {
                throw new ErrorException("Email already register");
            }
        } catch (ErrorException e) {
            String errorCode = ErrorEnum.ERR1.toString();
            ErrorResponse err = new ErrorResponse(errorCode, e.getMessage());
            throw new ErrorException(err.toString());
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
