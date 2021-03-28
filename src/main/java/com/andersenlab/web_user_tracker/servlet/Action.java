package com.andersenlab.web_user_tracker.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    void execute (HttpServletRequest request, HttpServletResponse response) throws IOException;
}
