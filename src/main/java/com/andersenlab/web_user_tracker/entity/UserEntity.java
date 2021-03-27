package com.andersenlab.web_user_tracker.entity;

import lombok.Value;

@Value
public class UserEntity {
    private long id;
    private String nickName;
    private String fullName;
    private String email;
    private boolean removed = false;
}
