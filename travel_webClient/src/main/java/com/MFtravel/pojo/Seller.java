package com.MFtravel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    private Long sid;
    private String sname;
    private String phone;
    private String address;
}
