package com.andersenlab.web_user_tracker.web;

import com.andersenlab.web_user_tracker.entity.UserEntity;
import com.andersenlab.web_user_tracker.exception.DataBaseConnectionException;
import com.andersenlab.web_user_tracker.jdbc.DBCPDataSource;
import com.andersenlab.web_user_tracker.repository.UserRepositoryJDBCImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    private UserRepositoryJDBCImpl repo;

    public void init() throws ServletException {
        super.init();
        try {
            Connection conn = DBCPDataSource.getConnection();
        } catch (SQLException e) {
            throw new DataBaseConnectionException(e);
        }
        repo = new UserRepositoryJDBCImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        findAllUsers(request, response);
    }

    private void findAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<UserEntity> userList = repo.findAll();
        request.setAttribute("userList", userList );
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/user-list.jsp");
        dispatcher.forward(request, response);
    }
}
