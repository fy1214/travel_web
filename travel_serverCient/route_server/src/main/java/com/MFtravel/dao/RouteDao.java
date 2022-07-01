package com.MFtravel.dao;

import com.MFtravel.pojo.Route;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RouteDao {
    @Autowired
    private BaseMapper<Route> baseMapper;

    /**
     * 根据页数查询数据
     * @param page  页数
     * @param rows  每页条数，默认每页十条
     * @return
     */
    public IPage<Route> queryByPage(Integer page, Integer rows, Integer cid, String rname){
        QueryWrapper<Route> queryWrapper = new QueryWrapper<>();
        if (cid != null) {
            queryWrapper.eq("belong", cid);
        }
        if (rname != null) {
            queryWrapper.like("rname", rname);
        }
        return this.baseMapper.selectPage(new Page<Route>(page, rows), queryWrapper);
    }
}
