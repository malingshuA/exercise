package com.exercise.exercise.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exercise.exercise.entity.Usere;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author malingshu
 * @since 2020-08-19
 */
@Mapper
@Repository
public interface UsereMapper extends BaseMapper<Usere> {

    @Insert("INSERT INTO usere (account, password) VALUES (#{account}, #{password})")
    public Object registered(String account,String password);
}
