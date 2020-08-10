package com.exercise.exercise.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author malingshu
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("用户实体类")
public class Usere implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @ApiModelProperty("用户id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty("用户昵称")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty("用户密码")
    private Integer age;

    /**
     * 邮箱
     */
    @ApiModelProperty("用户")
    private String email;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private Integer account;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;


}
