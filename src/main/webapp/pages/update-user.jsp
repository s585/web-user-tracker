<!DOCTYPE html>
<html>

<head>
    <title>Java Intensive</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/add-user-style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>User Tracker</h2>
    </div>
</div>

<div id="container">
    <h3>Update User</h3>

    <form action="UserEntityControllerServlet" method="POST">

<%--        <input type="hidden" name="command" value="UPDATE" />--%>

<%--        <input type="hidden" name="userId" value="${THE_USER.id}" />--%>

        <table>
            <tbody>

            <tr>
            <td><label>Id:</label></td>
            <td><input type="text" name="Id"
                       value="${THE_USER.id}" /></td>
            </tr>

            <tr>
                <td><label>Login:</label></td>
                <td><input type="text" name="login"
                           value="${THE_USER.login}" /></td>
            </tr>

            <tr>
                <td><label>First name:</label></td>
                <td><input type="text" name="firstName"
                           value="${THE_STUDENT.firstName}" /></td>
            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><input type="text" name="lastName"
                           value="${THE_STUDENT.lastName}" /></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email"
                           value="${THE_STUDENT.email}" /></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="UserEntityControllerServlet">Back to List</a>
    </p>
</div>
</body>

</html>
