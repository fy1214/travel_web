package com.MFtravel.dao;

import com.MFtravel.pojo.Route;
import com.MFtravel.pojo.RouteImg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImgDao {
    @Autowired
    private BaseMapper<RouteImg> baseMapper;

    public List<RouteImg> queryImg(Long id){
        QueryWrapper<RouteImg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("rid", id);
        return baseMapper.selectList(queryWrapper);
    }
}
