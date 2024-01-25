package com.example.springboot.config.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 重写UsernamePasswordToken,用于增加参数（将认证参数改为人脸）,便于登陆时的授权
 * 用于face数据库
 * admin不用更改使用默认的就好
 */
public class UserToken extends UsernamePasswordToken {
}
