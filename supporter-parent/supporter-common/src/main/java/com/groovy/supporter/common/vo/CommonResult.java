package com.groovy.supporter.common.vo;

public class CommonResult {
    Integer flag = 0;
    String message;
    Object data;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static CommonResult forSuccess(Object data){
        CommonResult commonResult = new CommonResult();
        commonResult.setData(data);
        return commonResult;
    }
    public static CommonResult forSuccess(){
        CommonResult commonResult = new CommonResult();
        return commonResult;
    }
    public static CommonResult forFail(Object data, String message){
        CommonResult commonResult = new CommonResult();
        commonResult.setData(data);
        commonResult.setFlag(1);
        commonResult.setMessage(message);
        return commonResult;
    }
}
