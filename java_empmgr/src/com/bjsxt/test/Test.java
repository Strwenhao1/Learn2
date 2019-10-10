package com.bjsxt.test;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.dao.impl.EmployeeDaoImpl;
import com.bjsxt.entity.Employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("*********欢迎进入员工管理系统**********");
            System.out.println("\t1.查询所有员工信息");
            System.out.println("\t2.查询指定编号的员工信息");
            System.out.println("\t3.添加员工信息");
            System.out.println("\t4.更新员工信息");
            System.out.println("\t5.删除员工信息");
            System.out.println("\t6.退出");
            int op = input.nextInt();
            switch (op){
                case 1:
                    findAll();
                    break;
                case 2:
                    findById();
                    break;
                case 3:
                    save();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;
                case 6:
                    System.out.println("谢谢使用");
                    return;
                default:
                    System.out.println("输入错误");
                    break;
            }
            System.out.println("按任意键继续");
            input.nextLine();
            input.nextLine();
        }while (true);

    }
    public static void delete(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入所要删除的员工编号");
        int empNo = input.nextInt();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        int n = employeeDao.delete(empNo);
        if(n > 0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }


    public static void update(){
        Scanner input = new Scanner(System.in);
        Employee emp = null;
        System.out.println("请输入员工编号");
        int empNo = input.nextInt();
        System.out.println("请输入员工职位");
        String job = input.next();
        System.out.println("请输入员工薪资");
        double sal = input.nextDouble();
        System.out.println("请输入员工上级编号");
        int mgr = input.nextInt();
        System.out.println("请输入员工部门编号");
        int deptNo = input.nextInt();
        emp = new Employee(empNo,job,mgr,sal,deptNo);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        int n = employeeDao.update(emp);
        if(n > 0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }


    public static void save(){
        Scanner input = new Scanner(System.in);
        Employee emp = null;
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        System.out.println("请输入员工姓名");
        String ename = input.next();
        System.out.println("请输入员工职位");
        String job = input.next();
        System.out.println("请输入员工上级编号");
        int mgr = input.nextInt();
        System.out.println("请输入员工入职时间");
        String sdate = input.next(); //"1999-11-22"
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date hireDate = null;
        try {
            hireDate = sdf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("请输入员工薪资");
        double sal = input.nextDouble();
        System.out.println("请输入员工津贴");
        double comm = input.nextDouble();
        System.out.println("请输入员工部门编号");
        int deptNo = input.nextInt();
        emp = new Employee(ename,job,mgr,hireDate,sal,comm,deptNo);
        int n = employeeDao.save(emp);
        if(n > 0){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }


    public static void findById() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要查询的员工编号");
        int empNo = input.nextInt();
        Employee emp = employeeDao.findById(empNo);
        if(emp != null){
            System.out.println("员工编号\t员工姓名\t员工职位\t员工上级编号\t员工入职时间\t员工薪资\t员工津贴\t员工部门编号");
            System.out.println(emp.getEmpNo() + "\t" + emp.getEname() + "\t" + emp.getJob()
                    + "\t" + emp.getMgr() + "\t" + emp.getHiredate() + "\t" + emp.getSal() + "\t" + emp.getComm() + "\t"
                    + emp.getDeptNo());
        }else {
            System.out.println("查无此人");
        }


    }

    public static void findAll() {
        //创建查询方法的实体类
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> list = new ArrayList<>();
        //调用findAdll
        list = employeeDao.findAll();
        System.out.println("员工编号\t员工姓名\t员工职位\t员工上级编号\t员工入职时间\t员工薪资\t员工津贴\t员工职位编号");
        for (Employee e : list) {
            System.out.println(e.getEmpNo() + "\t" + e.getEname() + "\t" + e.getJob()
                    + "\t" + e.getMgr() + "\t" + e.getHiredate() + "\t" + e.getSal() + "\t" + e.getComm() + "\t"
                    + e.getDeptNo());
        }
    }
}
