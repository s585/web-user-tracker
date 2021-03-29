package com.andersenlab.web_user_tracker.service;

import com.andersenlab.web_user_tracker.factory.UserRepositoryJDBCImplFactory;
import com.andersenlab.web_user_tracker.http.PageTitle;
import com.andersenlab.web_user_tracker.repository.UserRepository;
import com.andersenlab.web_user_tracker.web_page.RemoveUserPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveUserPageService implements PageService {
    private final RemoveUserPage removeUserPage = new RemoveUserPage();

    @Override
    public void createPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder responseTemplate = removeUserPage.getHeader(PageTitle.REMOVE_USER_PAGE);
        UserRepository repository = new UserRepositoryJDBCImplFactory().getRepository();
        if (request.getParameter("id") != null) {
            repository.removeById(Long.parseLong(request.getParameter("id")));
            responseTemplate.append(removeUserPage.getSuccessLabel());
        } else {
            responseTemplate.append(removeUserPage.getRemoveForm());
        }
        responseTemplate.append(removeUserPage.getFooterPage());
        response.getWriter().write(responseTemplate.toString());

    }
}
