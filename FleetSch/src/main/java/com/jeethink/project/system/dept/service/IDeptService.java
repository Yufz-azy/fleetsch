package com.jeethink.project.system.dept.service;

import java.util.List;

import com.jeethink.framework.web.domain.Ztree;
import com.jeethink.project.system.dept.domain.Dept;
import com.jeethink.project.system.role.domain.Role;

/**
 * 班级管理 服务层
 * 
 * @author jeethink www.jeethink.vip
 */
public interface IDeptService
{
    /**
     * 查询班级管理数据
     * 
     * @param dept 班级信息
     * @return 班级信息集合
     */
    public List<Dept> selectDeptList(Dept dept);

    /**
     * 查询班级管理树
     * 
     * @param dept 班级信息
     * @return 所有班级信息
     */
    public List<Ztree> selectDeptTree(Dept dept);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleDeptTreeData(Role role);

    /**
     * 查询班级人数
     * 
     * @param parentId 父班级ID
     * @return 结果
     */
    public int selectDeptCount(Long parentId);

    /**
     * 查询班级是否存在用户
     * 
     * @param deptId 班级ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 删除班级管理信息
     * 
     * @param deptId 班级ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增保存班级信息
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public int insertDept(Dept dept);

    /**
     * 修改保存班级信息
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public int updateDept(Dept dept);

    /**
     * 根据班级ID查询信息
     * 
     * @param deptId 班级ID
     * @return 班级信息
     */
    public Dept selectDeptById(Long deptId);

    /**
     * 校验班级名称是否唯一
     * 
     * @param dept 班级信息
     * @return 结果
     */
    public String checkDeptNameUnique(Dept dept);
}
