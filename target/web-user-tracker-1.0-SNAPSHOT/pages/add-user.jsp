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

    <form action="/SaveUserServlet" method="POST">

        <input type="hidden" name="command" value="ADD" />

        <table>
            <tbody>

            <tr>
                <td><label>nickname:</label></td>
                <td><input type="text" name="nickName" /></td>
            </tr>

            <tr>
                <td><label>Full Name:</label></td>
                <td><input type="text" name="fullName" /></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><input type="text" name="email" /></td>
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
        <a href="UserListServlet">Back to List</a>
    </p>
</div>
</body>

</html>
