package com.kingnod.service.impl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
public interface ShiroDbRealmInterface {
    /**
     * 认证回调函数,登录时调用.
     */
    public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException;
    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals);
    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    public void initCredentialsMatcher();
}