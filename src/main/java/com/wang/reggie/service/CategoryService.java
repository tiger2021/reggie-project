package com.wang.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.reggie.entity.Category;
import com.wang.reggie.mapper.CategoryMapper;

/**
 * @Author 小镇做题家
 * @create 2023/4/14 20:08
 * @Description:
 */
public interface CategoryService extends IService<Category> {

    public void remove(Long id);
}
