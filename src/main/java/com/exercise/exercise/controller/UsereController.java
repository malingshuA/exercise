package com.exercise.exercise.controller;


import com.exercise.exercise.service.UsereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private UsereService usereService;

    //注册
    @PostMapping("/registered" )
    public Object registered(@RequestParam("account") String account,
                             @RequestParam("password") String password,
                             @RequestParam("passwords") String passwords){
        usereService.registered(account,password,passwords);
        return null;
    }
//    public Object registered(Param("account") int account,
//                             Param("password") String password,
//                             Param("passworda") String passworda){
//        System.out.println(account);
//        System.out.println(password);
//        System.out.println(passworda);
//        return 1;
//    }

}

