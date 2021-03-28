package com.andersenlab.web_user_tracker.service;

import com.andersenlab.web_user_tracker.factory.UserRepositoryJDBCImplFactory;
import com.andersenlab.web_user_tracker.repository.UserRepository;
import com.andersenlab.web_user_tracker.web_page.HomePage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageService implements PageService {
    private final HomePage homePage = new HomePage();

    @Override
    public void createPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String pageTitle = "User Tracker";
        StringBuilder responseTemplate = homePage.getHeader(pageTitle);
        UserRepository repository = new UserRepositoryJDBCImplFactory().getRepository();
        responseTemplate.append(homePage.getTableUsers(repository.findAll()));
        response.getWriter().write(responseTemplate.toString());
    }
}
