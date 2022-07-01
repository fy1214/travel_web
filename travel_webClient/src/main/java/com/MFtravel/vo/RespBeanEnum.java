package com.MFtravel.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public enum RespBeanEnum {
    //通用
    SUCCESS(200, "SUCCESS"),
    ERROR(500,"服务端异常"),
    //登录模块5002xx
    LOGIN_ERROR(500210, "用户名或密码不正确"),
    SESSION_ERROR(500215, "用户不存在"),
    NOTLOGIN_ERROR(500220,"您尚未登录，请登录"),
    CAPTCHA_ERROR(500230, "验证码不正确"),
    //注册模块5003xx
    REGIST_ERROR(500310, "用户注册失败"),
    //秒杀模块5005xx
    EMPTY_STOCK(500500,"库存不足"),
    REPEATE_ERROR(500501,"该商品没人限购一件"),
    REQUEST_ILLEGAL(500502, "请求非法，请重新尝试"),
    ACCESS_LIMIT_REACHED(500504, "请求太频繁，请稍后再试"),
    //订单模块5006xx
    ORDER_NOT_EXIST(500600,"订单信息不存在"),
    //路线模块5007xx
    QUERYALL_FAIL(500700,"查找路线列表失败"),
    UPDATE_FAIL(500700,"修改房源失败"),
    //收藏模块5008xx
    ADDFAOURITE_FAIL(500800, "添加收藏失败"),
    REMOVE_FAIL(500801, "添加收藏失败");

    private final Integer code;
    private final String message;
}
