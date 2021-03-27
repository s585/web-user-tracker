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
    <h3>Add User</h3>

    <form action="/user_tracker/SaveUserServlet" method="GET">

<%--        <input type="hidden" name="command" value="ADD" />--%>

        <table>
            <tbody>

            <tr>
                <td><label>nickname:</label></td>
                <td><input type="text" name="nick_name" /></td>
            </tr>

            <tr>
                <td><label>Full Name:</label></td>
                <td><input type="text" name="full_name" /></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email" /></td>
            </tr>

            <tr>
                <td><label></label></td>
<%--                <td><input type="submit" value="Save" class="save" /></td>--%>
                <button type="submit" class="btn btn-success">Save</button>
            </tr>

            </tbody>
        </table>
    </form>

    <div style="clear: both;"></div>

    <p>
        <a href="/user_tracker/UserListServlet">Back to List</a>
    </p>
</div>
</body>

</html>
