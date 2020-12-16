package com.superb.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoEntity implements Serializable {
    private static final long serialVersionUID = -3149789737737124075L;

    private Long id;

    private String name;

    private String sex;

    private String address;

    private Integer age;
}
