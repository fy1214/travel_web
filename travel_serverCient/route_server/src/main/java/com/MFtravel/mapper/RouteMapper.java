package com.MFtravel.mapper;

import com.MFtravel.pojo.Route;
import com.MFtravel.pojo.RouteDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RouteMapper extends BaseMapper<Route> {
    RouteDetail getRouteDetailById(Long id);
}
