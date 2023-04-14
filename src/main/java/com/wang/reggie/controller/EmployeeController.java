package com.wang.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wang.reggie.common.R;
import com.wang.reggie.entity.Employee;
import com.wang.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 小镇做题家
 * @create 2023/4/12 21:55
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        //将页面提交的密码进行md5加密处理
        String password = employee.getPassword();
        password=DigestUtils.md5DigestAsHex(password.getBytes());

        //根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper=new LambdaQueryWrapper<>();
        // Employee::getUsername 查询SQL表里面的用户名
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        //如果没有查询到，则返回用户名错误
        if(emp==null){
            return R.error("请输入正确的用户名。。。");
        }

        //判断密码是否正确
        if(!emp.getPassword().equals(password)){
           return R.error("密码错误");
        }

        //判断账号是否已禁用
        if(emp.getStatus()==0){
           return R.error("账号已禁用");
        }

        //登录成功，将员工的id写入Session
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){

        request.getSession().removeAttribute("employee");
        return R.success("成功退出");
    }



}
