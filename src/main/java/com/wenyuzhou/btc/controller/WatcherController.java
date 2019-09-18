package com.wenyuzhou.btc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wenyuzhou.btc.pojo.Response;
import com.wenyuzhou.btc.pojo.UserInfo;
import com.wenyuzhou.btc.service.WatcherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author : Wenyu Zhou
 * @version : v1.0
 * @date : 2019/9/17
 * description : 描述
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/watcher")
public class WatcherController {
    @Resource
    private WatcherService service;

    @PostMapping("/login")
    public Response<UserInfo> login(@RequestBody String str, HttpSession session){
        JSONObject js = null;
        try {
            js = JSON.parseObject(str);
            if(js.containsKey("user") && js.containsKey("pwd")){
                String user = js.getString("user");
                String pwd = js.getString("pwd");
                if(user.length()>20 || pwd.length()>20){
                    return new Response<>(500,"username or password is too long");
                }else {
                    Response<UserInfo> r = service.login(user,pwd);
                    if(r.getCode() == 200){
                        session.setAttribute("userInfo",r.getData());
                    }
                    return r;
                }
            }else {
                return new Response<>(500,"please don't attack server");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(500);
        }
    }

    @PostMapping("/changePrice")
    public Response changePrice(@RequestBody String param,@SessionAttribute UserInfo userInfo){
        log.info(param);
        log.info(userInfo.toString());
        return new Response(200);
    }
}
