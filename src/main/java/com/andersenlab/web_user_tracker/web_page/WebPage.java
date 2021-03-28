package com.andersenlab.web_user_tracker.web_page;

public interface WebPage {
    default StringBuilder getHeader() {
        return new StringBuilder().append("<html>\n"
                + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">"
                + "<body>\n");
    }

    default StringBuilder getFooterPage() {
        return new StringBuilder().append("</body>\n" + "</html>");
    }

    default StringBuilder getHeader(String title) {
        StringBuilder responseTemplate = getHeader();
        responseTemplate.append("<h2>" + title + "</h2>\n");
        responseTemplate.append("<form action=\"\" method=\"post\">"
                + "<input type=\"hidden\" id=\"action\" name=\"action\" value=\"home\">"
                + "<input type=\"submit\" value=\"Home\" /></form>   ");
        responseTemplate.append("<form action=\"\" method=\"post\">"
                + "<input type=\"hidden\" id=\"action\" name=\"action\" value=\"add\">"
                + "<input type=\"submit\" value=\"AddUser\" /></form>   ");
        responseTemplate.append("<form action=\"\" method=\"post\">"
                + "<input type=\"hidden\" id=\"action\" name=\"action\" value=\"remove\">"
                + "<input type=\"submit\" value=\"RemoveUser\" /></form>   ");
        return responseTemplate;
    };
}
