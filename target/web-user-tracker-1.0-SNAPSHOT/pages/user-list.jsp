<%@ page import="com.andersenlab.web_user_tracker.entity.UserEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Tracker</title>
</head>
<body>

<div class="row">

    <div class="container">
        <h3 class="text-center">Users</h3>
        <hr>
        <div class="container text-left">
        </div>
        <br>
        <input type="button" value="Add User"
               onclick="window.location.href='/pages/add-user.jsp'; return false;"
               class="add-user-button"
        />
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>nickname</th>
                <th>Full Name</th>
                <th>email</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<UserEntity> users = (ArrayList<UserEntity>) request.getAttribute("userList");

                for (UserEntity user : users) {
                    out.print("<tr>");
                    out.print("<td>");
                    out.print(user.getId());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(user.getNickName());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(user.getFullName());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(user.getEmail());
                    out.print("</td>");
                    out.print("</tr>");
                }
            %>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
