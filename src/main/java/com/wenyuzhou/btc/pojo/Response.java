package com.wenyuzhou.btc.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Wenyu Zhou
 * @version : v1.0
 * @date : 2019/9/17
 * description : 描述
 */
@Data
public class Response<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public Response(int code){
        this.code = code;
    }
    public Response(int code, String msg){
        if(code == 200){
            this.msg = "success";
        }else {
            this.msg = msg;
        }
        this.code = code;
    }
    public Response(int code, String msg,T data){
        if(code == 200){
            this.msg = "success";
        }else {
            this.msg = msg;
        }
        this.code = code;
        this.data = data;
    }

}
