package com.MFtravel.service;

import com.MFtravel.pojo.RouteDetail;
import com.MFtravel.vo.RouteVo;

public interface RouteService {

    /**
     * 根据条件查询整页信息
     * @param page
     * @param rows
     * @param cid
     * @param rname
     * @return
     */
    RouteVo queryPage(Integer page, Integer rows, Integer cid, String rname);

    /**
     * 根据id查询路线详细信息
     * @param id
     * @return
     */
    RouteDetail queryDetail(Long id, String tickt);

    /**
     * 根据用户cookie和rid添加喜欢列表
     * @param rid
     * @param ticket
     * @return
     */
    boolean addFavourite(Long rid, String ticket);

    /**
     * 根据用户cookie和rid删除喜欢列表
     * @param rid
     * @param ticket
     * @return
     */
    boolean removeFavorite(Long rid, String ticket);
}
