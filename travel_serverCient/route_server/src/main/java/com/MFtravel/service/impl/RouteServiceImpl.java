package com.MFtravel.service.impl;

import com.MFtravel.dao.FavouriteDao;
import com.MFtravel.dao.ImgDao;
import com.MFtravel.dao.RouteDao;
import com.MFtravel.mapper.RouteMapper;
import com.MFtravel.pojo.Favourite;
import com.MFtravel.pojo.Route;
import com.MFtravel.pojo.RouteDetail;
import com.MFtravel.pojo.User;
import com.MFtravel.service.RouteService;
import com.MFtravel.vo.RouteVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private RouteDao routeDao;
    @Autowired
    private ImgDao imgDao;
    @Autowired
    private FavouriteDao favouriteDao;

    @Override
    public RouteVo queryPage(Integer page, Integer rows, Integer cid, String rname) {
        IPage<Route> iPage = routeDao.queryByPage(page, rows, cid, rname);
        RouteVo routeVo = new RouteVo();
        routeVo.setTotalPage(iPage.getPages());
        routeVo.setTotalCount(iPage.getTotal());
        routeVo.setCurrentPage(page);
        routeVo.setRecords(iPage.getRecords());
        return routeVo;
    }

    @Override
    public RouteDetail queryDetail(Long id, String ticket) {
        User user = (User) redisTemplate.opsForValue().get("user:" + ticket);
        RouteDetail routeDetail = routeMapper.getRouteDetailById(id);
        routeDetail.setRouteImgList(imgDao.queryImg(id));
        routeDetail.setFavourite(favouriteDao.checkFavourite(id, user.getUid()));
        return routeDetail;
    }

    @Override
    public boolean addFavourite(Long rid, String ticket) {
        User user = (User) redisTemplate.opsForValue().get("user:" + ticket);
        Favourite favourite = new Favourite();
        favourite.setRid(rid);
        favourite.setDate(new Date());
        favourite.setUid(user.getUid());
        return favouriteDao.addFavourite(favourite) == 1;
    }

    @Override
    public boolean removeFavorite(Long rid, String ticket) {
        User user = (User) redisTemplate.opsForValue().get("user:" + ticket);
        return favouriteDao.removeFavourite(rid, user.getUid()) == 1;
    }
}
