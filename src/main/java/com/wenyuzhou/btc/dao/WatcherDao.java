package com.wenyuzhou.btc.dao;

import com.wenyuzhou.btc.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author : Wenyu Zhou
 * @version : v1.0
 * @date : 2019/9/17
 * description : 描述
 */
@Mapper
public interface WatcherDao {
    /**
     * longin
     * @param username user
     * @return userInfo
     */
    @Select("select * from user_info where username = #{username}")
    UserInfo selectUserByUsername(@Param("username")String username);

}
