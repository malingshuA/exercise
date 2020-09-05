package com.exercise.exercise.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.exercise.exercise.entity.Usere;
import com.exercise.exercise.mapper.UsereMapper;
import com.exercise.exercise.service.UsereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author malingshu
 * @since 2020-08-19
 */
@Service
public class UsereServiceImpl extends ServiceImpl<UsereMapper, Usere> implements UsereService {

    @Autowired
    private UsereMapper usereMapper;

    @Override
    public Object registered(String account, String password, String passwords) {
        Usere usere = new Usere();
        usere.setAccount(account);
        usere.setPassword(password);
        usereMapper.insert(usere);

//        if(account == ""||account == null){
//            return "账号不能为空";
//            //eturn model.addAttribute("error","账号不能为空");
//        }
//        if (account.length()==11){
//            String aa = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";
//           // String aa = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\\\d{8}$";
//            boolean bb = Pattern.matches(aa,account);
//            if(!bb){
//                return "手机号格式错误，请重新输入";
//               // return model.addAttribute("error","手机号格式错误，请重新输入");
//            }
//        }else{
//            return "手机号格式错误，请重新输入";
//            //return model.addAttribute("error","手机号格式错误，请重新输入");
//        }
//        if(password.length()>32){
//            return "密码最大输入32位";
//            //return model.addAttribute("error","密码最大输入32位");
//        }
//        if(!password.equals(passwords)){
//            return "密码输入不一致请重新输入";
//            //return model.addAttribute("error","密码输入不一致请重新输入");
//        }

        //usereMapper.registered(account,password);
        return "注册成功，请登录";
        //return model.addAttribute("error","注册成功，请登录");
    }
}
