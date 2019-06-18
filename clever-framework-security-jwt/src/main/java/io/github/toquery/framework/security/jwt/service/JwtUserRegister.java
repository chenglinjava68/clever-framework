package io.github.toquery.framework.security.jwt.service;


import io.github.toquery.framework.security.system.domain.SysUser;

/**
 * @author toquery
 * @version 1
 */
public interface JwtUserRegister {
    public SysUser register(SysUser user);
}