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

    public StringBuilder getSortedForm() {
        StringBuilder responseTemplate = new StringBuilder();
        responseTemplate.append("<form action=\"\" method=\"post\">");

        responseTemplate.append(
                "<input type=\"radio\" id=\"nickName\"\r\n" + "     name=\"arg\" value=\"nick_name\" required />\r\n"
                        + "    <label for=\"nickName\">nick</label>\r\n");
        responseTemplate.append(
                "<input type=\"radio\" id=\"fullName\"\r\n" + "     name=\"arg\" value=\"full_name\" required />\r\n"
                        + "    <label for=\"nickName\">name</label>\r\n");

        responseTemplate.append(
                "<input type=\"radio\" id=\"email\"\r\n" + "     name=\"arg\" value=\"email\" required />\r\n"
                        + "    <label for=\"nickName\">email</label>\r\n");

        responseTemplate.append("<br>");

//        responseTemplate.append("<input type=\"radio\" id=\"increase\"\r\n"
//                + "     name=\"howToChange\" value=\"increase\" required />\r\n"
//                + "    <label for=\"username\">Increase</label>\r\n");
//
//        responseTemplate.append("<input type=\"radio\" id=\"decrease\"\r\n"
//                + "     name=\"howToChange\" value=\"decrease\" required />\r\n"
//                + "    <label for=\"username\">Decrease</label>\r\n");

        responseTemplate.append("<input type=\"hidden\" id=\"action\" name=\"action\" value=\"home\">");

        responseTemplate.append("<input type=\"submit\" value=\"Sort\" />");

        responseTemplate.append("</form> ");
        return responseTemplate;
    };
}
