package com.bjsxt.dao;

import com.bjsxt.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * 查询所有员工信息
     * @return
     */
    public List<Employee> findAll();

    /**
     * 通过员工Id查询员工信息
     * @param empNo
     * @return
     */
    public Employee findById(int empNo);

    /**
     * 添加员工信息
     * @param emp
     * @return
     */
    public int save(Employee emp);

    /**
     * 更新员工信息
     * @param emp
     * @return
     */
    public int update(Employee emp);

    /**
     * 通过员工Id删除指定员工
     * @param empNo
     * @return
     */
    public int delete(int empNo);
}
