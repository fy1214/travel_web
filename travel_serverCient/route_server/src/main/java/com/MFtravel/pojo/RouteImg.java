package com.MFtravel.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_route_img")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteImg {
    private Long rgid;
    private Long rid;
    private String bigPic;
    private String smallPic;
}
