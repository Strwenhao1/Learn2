package com.bjsxt.dao.impl;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.entity.Employee;
import com.bjsxt.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> findAll() {
        String sql = "select * from emp";
        Object[]  parmas = {};
        return DBUtil.executeQuery(sql,parmas,Employee.class);
    }

    @Override
    public Employee findById(int empNo) {
        String sql = "select * from emp where empno = ?";
        Object parmars[] = {empNo};
        List<Employee> list = DBUtil.executeQuery(sql, parmars);
        if(list.size()==0){
            return null;
        }else {
            return list.get(0);
        }

    }

    @Override
    public int save(Employee emp) {
        String sql = "insert into emp values(null,?,?,?,?,?,?,?)";
        Object [] parmars = {emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),
                emp.getComm(),emp.getDeptNo()};
        return DBUtil.executeUpdate(sql,parmars);
    }

    @Override
    public int update(Employee emp) {
        String sql = "update emp set job = ?, mgr=?, sal= ?, deptno = ? where empno = ?";
        Object [] parmars = {emp.getJob(),emp.getMgr(),emp.getSal(),
               emp.getDeptNo(),emp.getEmpNo()};
        return DBUtil.executeUpdate(sql,parmars);
    }

    @Override
    public int delete(int empNo) {
        String sql = "delete from emp where empno = ?";
        Object [] parmars = {empNo};
        return DBUtil.executeUpdate(sql,parmars);
    }
}
