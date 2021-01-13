package com.example.vo;

import lombok.Data;

@Data
public class SysResult {
    /*状态码*/
    private int code = 200;
    /*状态码对应的状态信息*/
    private String msg = "ok";
    /**正常数据*/
    private Object data;
    public SysResult(String msg) {
        this.msg=msg;
    }
    public SysResult(Object data) {
        this.data=data;
    }
    /**出现异常时时调用*/
    public SysResult(Throwable t){
        this.code=0;
        this.msg=t.getMessage();
    }

}