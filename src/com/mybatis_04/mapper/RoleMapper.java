package com.mybatis_04.mapper;

import com.mybatis_04.pojo.Role;

import java.util.List;

/**
 * @author Nigori
 * @date 2020/5/8
 **/
public interface RoleMapper {
    public int insertRole(Role role);
    public int deleteRole(int id);
    public int updateRole(Role role);
    public List<Role> findRole(String roleName);
    public Role getRole(int id);
}
