package com.wenyuzhou.btc.pojo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Wenyu Zhou
 * @version : v1.0
 * @date : 2019/9/17
 * description : 描述
 */
public class StaticBase {
    public static Map<String,UserInfo> userMap = new ConcurrentHashMap<>(16);
}
