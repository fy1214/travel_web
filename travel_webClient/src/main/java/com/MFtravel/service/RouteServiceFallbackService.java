package com.MFtravel.service;

import com.MFtravel.vo.route.RouteDetail;
import com.MFtravel.vo.route.RouteVo;
import org.springframework.stereotype.Component;

@Component
public class RouteServiceFallbackService implements RouteService{
    @Override
    public RouteVo pageQuery(Integer page, Integer rows, Integer cid, String rname) {
        return null;
    }

    @Override
    public RouteDetail queryDetail(Long id, String ticket) {
        return null;
    }

    @Override
    public boolean addFavourite(Long rid, String ticket) {
        return false;
    }

    @Override
    public boolean removeFavorite(Long rid, String ticket) {
        return false;
    }
}
