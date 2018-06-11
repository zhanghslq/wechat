package com.yb.shiro.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


import com.yb.entity.Admin;


/**
 *自定义realm
 */
public class CustomerRealm extends AuthorizingRealm {
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

		return simpleAuthorizationInfo;
	}

	/**
	 * 认证，通过字符串匹配v
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
		AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken loginToken=(UsernamePasswordToken)token;
        String password=new String(loginToken.getPassword());
        if(loginToken.getUsername()=="admin"&&password.equals("admintest123")){
            SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(loginToken.getUsername(),password,getName());
            return info;
        }else{
            throw new IncorrectCredentialsException("密码错误");
        }

	}

}
