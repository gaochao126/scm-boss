package com.superb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 7738780726973309301L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "user_sex")
    private Integer userSex;

    @TableField(value = "user_address")
    private String userAddress;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
