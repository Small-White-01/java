package com.lezijie.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @author aaa
 * @since 2021-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TUser对象", description="")
public class TUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private int id;

    @ApiModelProperty(value = "备注")
    private String bz;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    @TableField("trueName")
    private String truename;

    @ApiModelProperty(value = "用户名")
    @TableField("userName")//数据库字段名
    private String username;

    @ApiModelProperty(value = "评论")
    private String remarks;

    @ApiModelProperty(value = "是否删除")
    @TableField("isDel")
    private String isdel;


}
