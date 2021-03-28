package com.andersenlab.web_user_tracker.web_page;

import com.andersenlab.web_user_tracker.entity.UserEntity;

import java.util.List;

public class HomePage implements WebPage {

    public StringBuilder getTableUsers(List<UserEntity> listUsers) {
        StringBuilder responseTemplate = new StringBuilder();
        responseTemplate.append("<table border=\"1\">");
        listUsers.forEach(user -> {
            responseTemplate.append(getTableRowUser(user));
        });
        responseTemplate.append("</table>");
        return responseTemplate;
    }

    public StringBuilder getTableRowUser(UserEntity user) {
        StringBuilder responseTemplate = new StringBuilder();
        responseTemplate.append(
                "  <tr>\r\n" +
                        "<td>" + user.getId() + "</td>" +
                        "<td>" + user.getNickName() + "</td>" +
                        "<td>" + user.getFullName() + "</td>" +
                        "<td>" + user.getEmail() + "</td>" +
                        "  </tr>\r\n");
        return responseTemplate;
    }
}
