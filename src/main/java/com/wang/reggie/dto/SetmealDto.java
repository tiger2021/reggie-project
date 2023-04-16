package com.wang.reggie.dto;

import com.wang.reggie.entity.Setmeal;
import com.wang.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
