package com.wenyuzhou.btc.service.impl;

import com.wenyuzhou.btc.dao.WatcherDao;
import com.wenyuzhou.btc.pojo.Response;
import com.wenyuzhou.btc.pojo.StaticBase;
import com.wenyuzhou.btc.pojo.UserInfo;
import com.wenyuzhou.btc.service.WatcherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author : Wenyu Zhou
 * @version : v1.0
 * @date : 2019/9/17
 * description : 描述
 */
@Service
public class WatcherServiceImpl implements WatcherService {
    @Resource
    private WatcherDao dao;

    @Override
    public Response<UserInfo> login(String username, String password) {
        UserInfo userInfo = dao.selectUserByUsername(username);
        if(userInfo == null || userInfo.getUsername()==null){
            return new Response<>(500,"Username is empty");
        }else if (!password.equals(userInfo.getPassword())){
            return new Response<>(500,"password wrong!");
        }else {
            UUID uuid = UUID.randomUUID();
            userInfo.setToken(uuid.toString());
            userInfo.setModifyTime(new Date());
            StaticBase.userMap.put(uuid.toString(),userInfo);
            return new Response<>(200,"",userInfo);
        }
    }
}
