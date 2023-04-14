package com.wang.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.reggie.entity.Employee;
import com.wang.reggie.mapper.EmployeeMapper;
import com.wang.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @Author 小镇做题家
 * @create 2023/4/12 21:52
 * @Description:
 */

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
