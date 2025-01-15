package com.romantrippel.tllh.service;


import com.romantrippel.tllh.util.StringUtil;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class UserService {

    //TODO Fix after added DB
    public boolean authenticate(String username, String password) {
        if (StringUtil.isEmptyOrBlank(username) || StringUtil.isEmptyOrBlank(password)) {

            return false;
        }

        return true;
    }
}
