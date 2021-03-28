package com.andersenlab.web_user_tracker.service;

import com.andersenlab.web_user_tracker.web_page.WebPage;

public class AddUserPage implements WebPage {
    public StringBuilder getFormAdding() {
        StringBuilder responseTemplate = new StringBuilder();
        responseTemplate.append("<form action=\"\" method=\"post\">");
        responseTemplate.append(
                "<label>Enter Id</label><input placeholder=\"Enter Id\" name=\"id\" required /><br>");
        responseTemplate.append(
                "<label>Enter login</label><input placeholder=\"Enter login\" name=\"login\" required /><br>");
        responseTemplate.append(
                "<label>Enter full name</label><input placeholder=\"Enter full name\" name=\"fullName\" required /><br>");
        responseTemplate
                .append("<label>Enter email</label> <input placeholder=\"Enter email \" name=\"email\" required /><br>");
        responseTemplate.append("<input type=\"hidden\" id=\"action\" name=\"action\" value=\"add\">");
        responseTemplate.append("<input type=\"submit\" value=\"Add user\" />");
        responseTemplate.append("</form> ");
        return responseTemplate;
    }

    public StringBuilder getSuccessfulLabel() {
        return new StringBuilder().append("<h4>User is added</h>");
    }

}
