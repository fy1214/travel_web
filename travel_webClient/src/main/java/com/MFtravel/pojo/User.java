package com.MFtravel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long uid;
    private String username;
    private String password;
    private String name;
    private Date birth;
    private String sex;
    private String telephone;
    private String email;
    private String status;
}
