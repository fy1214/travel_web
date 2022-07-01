package com.MFtravel.dao;

import com.MFtravel.pojo.Favourite;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FavouriteDao {
    @Autowired
    private BaseMapper<Favourite> baseMapper;

    public Favourite checkFavourite(Long rid, Long uid) {
        QueryWrapper<Favourite> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("rid", rid);
        queryWrapper.eq("uid", uid);
        return baseMapper.selectOne(queryWrapper);
    }

    public Integer addFavourite(Favourite favourite){
        Integer res = 0;
        try {
            if (checkFavourite(favourite.getRid(), favourite.getUid()) == null) {
                res = baseMapper.insert(favourite);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public Integer removeFavourite(Long rid, Long uid){
        Integer res = 0;
        try {
            QueryWrapper<Favourite> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("rid", rid);
            queryWrapper.eq("uid", uid);
            res = baseMapper.delete(queryWrapper);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
