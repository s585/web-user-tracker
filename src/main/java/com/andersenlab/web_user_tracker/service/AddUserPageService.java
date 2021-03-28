package com.andersenlab.web_user_tracker.service;

import com.andersenlab.web_user_tracker.entity.UserEntity;
import com.andersenlab.web_user_tracker.factory.UserRepositoryJDBCImplFactory;
import com.andersenlab.web_user_tracker.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.IOException;

public class AddUserPageService implements PageService {
    private final AddUserPage addUserPage = new AddUserPage();

    @Override
    public void createPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String pageTitle = "User Tracker";
        StringBuilder responseTemplate = addUserPage.getHeader(pageTitle);
        UserRepository repository = new UserRepositoryJDBCImplFactory().getRepository();
        if (request.getParameter("login") != null &&
                request.getParameter("fullName") != null &&
                request.getParameter("email") != null) {
            UserEntity user = new UserEntity(
                    Long.parseLong(request.getParameter("id")),
                    request.getParameter("login"),
                    request.getParameter("fullName"),
                    request.getParameter("email")
            );
            repository.save(user);
            responseTemplate.append(addUserPage.getSuccessfulLabel());
        } else {
            responseTemplate.append(addUserPage.getFormAdding());
        }
        responseTemplate.append(addUserPage.getFooterPage());
        response.getWriter().write(responseTemplate.toString());
    }
}
