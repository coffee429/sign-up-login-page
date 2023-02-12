package com.blackhoodie.controller.user;

import com.blackhoodie.model.Account;
import com.blackhoodie.model.User;
import com.blackhoodie.repository.UserRepository;
import com.blackhoodie.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Boolean signup(SignUpRequest req) {
        try {
            User user = new User(
                    req.getName(),
                    req.getGender(),
                    req.getPhoneNumber(),
                    req.getEmail()
            );
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
