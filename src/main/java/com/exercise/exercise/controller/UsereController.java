package com.exercise.exercise.controller;


import com.exercise.exercise.service.UsereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author malingshu
 * @since 2020-08-19
 */
//@RestController
@RequestMapping("/usere")
@Controller
public class UsereController {

    @Autowired
    private UsereService usereService;

    //注册
    @PostMapping("/registered" )
    public Object registered(@RequestParam("account") String account,
                             @RequestParam("password") String password,
                             @RequestParam("passwords") String passwords){
        usereService.registered(account,password,passwords);
        return "注册成功";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","王八蛋");
        return "index";
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

