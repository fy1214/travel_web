package com.MFtravel.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    private Long sid;
    private String sname;
    private String phone;
    private String address;
}
