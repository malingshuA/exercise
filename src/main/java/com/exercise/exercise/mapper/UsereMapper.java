package com.exercise.exercise.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exercise.exercise.entity.Usere;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author malingshu
 * @since 2020-08-19
 */
@Component
public interface UsereMapper extends BaseMapper<Usere> {

    @Insert("INSERT INTO usere (account, password) values (#{account}, #{password})")
    public Object registered(String account,String password);
}
