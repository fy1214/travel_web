package com.MFtravel.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@TableName("t_route")   //指定实体和所对应的表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

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
