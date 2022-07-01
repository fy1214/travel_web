package com.MFtravel.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_favorite")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favourite {
    private Long rid;
    private Date date;
    private Long uid;
}
