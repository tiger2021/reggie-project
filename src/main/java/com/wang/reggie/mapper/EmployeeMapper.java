package com.wang.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author 小镇做题家
 * @create 2023/4/12 21:49
 * @Description:
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
