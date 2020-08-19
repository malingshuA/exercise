package com.exercise.exercise.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author malingshu
 * @since 2020-08-19
 */
@RestController
@RequestMapping("/usere")
public class UsereController {

    //注册
    @RequestMapping("/registered")
    public Object registered(@RequestParam("account") int account,
                             @RequestParam("password") String password,
                             @RequestParam("passworda") String passworda){

    }

}

