package com.jeethink.project.system.role.mapper;

import java.util.List;

import com.jeethink.project.system.role.domain.RoleDept;

/**
 * 角色与班级关联表 数据层
 * 
 * @author jeethink www.jeethink.vip
 */
public interface RoleDeptMapper
{
    /**
     * 通过角色ID删除角色和班级关联
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleDeptByRoleId(Long roleId);

    /**
     * 批量删除角色班级关联信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleDept(Long[] ids);

    /**
     * 查询班级使用数量
     * 
     * @param deptId 班级ID
     * @return 结果
     */
    public int selectCountRoleDeptByDeptId(Long deptId);

    /**
     * 批量新增角色班级信息
     * 
     * @param roleDeptList 角色班级列表
     * @return 结果
     */
    public int batchRoleDept(List<RoleDept> roleDeptList);
}
