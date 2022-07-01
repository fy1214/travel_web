package com.MFtravel.vo;

import com.MFtravel.pojo.Route;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteVo {
    private Long totalPage;
    private Long totalCount;
    private Integer currentPage;
    private List<Route> records;
}
