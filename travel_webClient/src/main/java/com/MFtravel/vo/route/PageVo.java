package com.MFtravel.vo.route;

import com.MFtravel.pojo.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    private Integer totalPage;
    private Integer totalCount;
    private List<Route> routeList;
}
