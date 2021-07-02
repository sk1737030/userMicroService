package com.example.usermicroservice.dto;

import com.example.usermicroservice.vo.ResponseOrder;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private String email;
    private String pwd;
    private String name;
    private String userId;
    private Date createdAt;
    private String encryptedPwd;

    private List<ResponseOrder> orders;

    public void setOrders(List<ResponseOrder> orders) {
        this.orders = orders;
    }
}
