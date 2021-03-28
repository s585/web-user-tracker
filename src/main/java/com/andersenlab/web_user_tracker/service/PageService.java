package com.andersenlab.web_user_tracker.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PageService {
    void createPage(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
