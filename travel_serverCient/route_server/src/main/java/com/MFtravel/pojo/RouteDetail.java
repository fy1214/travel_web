package com.MFtravel.pojo;

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
