package com.andersenlab.web_user_tracker.service;

import com.andersenlab.web_user_tracker.factory.UserRepositoryJDBCImplFactory;
import com.andersenlab.web_user_tracker.http.PageTitle;
import com.andersenlab.web_user_tracker.repository.UserRepository;
import com.andersenlab.web_user_tracker.web_page.HomePage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageService implements PageService {
    private final HomePage homePage = new HomePage();

    @Override
    public void createPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder responseTemplate = homePage.getHeader(PageTitle.HOME_PAGE);
        UserRepository repository = new UserRepositoryJDBCImplFactory().getRepository();
        responseTemplate.append(homePage.getSortedForm());
        if (request.getParameter("arg") != null) {
            responseTemplate.append(homePage.getTableUsers(repository.findAllOrderedBy(request.getParameter("arg"))));
        } else {
            responseTemplate.append(homePage.getTableUsers(repository.findAll()));
        }
        response.getWriter().write(responseTemplate.toString());
    }
}
