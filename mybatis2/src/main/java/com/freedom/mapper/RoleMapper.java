package com.freedom.mapper;
import com.freedom.po.Role;

public interface RoleMapper {
    public Role getRole(Long id);

    public int insertRole(Role role);

    public int deleteRole(Long id);
}
