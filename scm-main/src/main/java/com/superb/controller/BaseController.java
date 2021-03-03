package com.superb.controller;

import com.superb.model.UserEntity;
import com.superb.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "baseController")
@Slf4j
public class BaseController {

    @Autowired
    UserService userService;

    @GetMapping(value = "login")
    public String login(@RequestParam("sex") int sex) {

        List<UserEntity> userBySex = userService.listUser();

        System.out.println(userBySex.toString());

        return userBySex.toString();
    }
}
