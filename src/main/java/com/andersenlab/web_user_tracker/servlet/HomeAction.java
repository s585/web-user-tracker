package com.andersenlab.web_user_tracker.servlet;

import com.andersenlab.web_user_tracker.service.HomePageService;
import com.andersenlab.web_user_tracker.service.PageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeAction implements Action {
    private final PageService service = new HomePageService();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.createPage(request, response);
    }
}