package com.MFtravel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    private Long rid;
    private String rname;
    private double rprice;
    private String routeIntroduce;
    private Integer rflag;
    private Date rdate;
    private Integer isThemeTour;
    private Long count;
    private Integer belong;
    private String rimage;
    private Long sid;
}
