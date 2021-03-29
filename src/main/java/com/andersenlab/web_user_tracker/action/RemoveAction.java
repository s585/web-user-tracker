package com.andersenlab.web_user_tracker.action;

import com.andersenlab.web_user_tracker.service.PageService;
import com.andersenlab.web_user_tracker.service.RemoveUserPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveAction implements Action {
    private final PageService service = new RemoveUserPageService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.createPage(request, response);

    }
}
