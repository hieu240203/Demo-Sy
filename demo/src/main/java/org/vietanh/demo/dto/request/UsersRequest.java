package org.vietanh.demo.dto.request;

import lombok.Data;

@Data
public class UsersRequest {
    private String email;
    private String password;
}
