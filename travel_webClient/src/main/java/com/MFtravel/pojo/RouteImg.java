package com.MFtravel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteImg {
    private Long rgid;
    private Long rid;
    private String bigPic;
    private String smallPic;
}
