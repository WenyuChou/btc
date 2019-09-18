package com.wenyuzhou.btc.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author : Wenyu Zhou
 * @version : v1.0
 * @date : 2019/9/17
 * description : 描述
 */
@Data
public class UserInfo {

    private Integer id;
    private String username;
    private String password;
    private String tel;
    private String email;
    private String qq;
    private String token;
    private Double top;
    private Double bottom;
    private Date modifyTime;

}
