package com.andersenlab.web_user_tracker.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T map (ResultSet rs);
}
