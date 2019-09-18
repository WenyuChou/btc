package com.wenyuzhou.btc.service;

import com.wenyuzhou.btc.pojo.Response;
import com.wenyuzhou.btc.pojo.UserInfo;

/**
 * @author : Wenyu Zhou
 * @version : v1.0
 * @date : 2019/9/17
 * description : 描述
 */
public interface WatcherService {
    /**
     * 登录
     * @param username user
     * @param password  pwd
     * @return userInfo
     */
    Response<UserInfo> login(String username, String password);
}
