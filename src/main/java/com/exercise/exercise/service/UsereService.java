package com.exercise.exercise.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.exercise.exercise.entity.Usere;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author malingshu
 * @since 2020-08-19
 */
public interface UsereService extends IService<Usere> {

    public Object registered(String account, String password, String passwords);

}
