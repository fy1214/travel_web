package com.MFtravel.vo.route;

import com.MFtravel.pojo.Favourite;
import com.MFtravel.pojo.Route;
import com.MFtravel.pojo.RouteImg;
import com.MFtravel.pojo.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDetail {
    private Route route;
    private Seller seller;
    private List<RouteImg> routeImgList;
    private Favourite favourite;
}
