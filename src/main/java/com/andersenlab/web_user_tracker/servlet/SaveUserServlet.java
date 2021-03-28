package com.andersenlab.web_user_tracker.servlet;

import com.andersenlab.web_user_tracker.entity.UserEntity;
import com.andersenlab.web_user_tracker.exception.DataBaseConnectionException;
import com.andersenlab.web_user_tracker.jdbc.DBCPDataSource;
import com.andersenlab.web_user_tracker.repository.UserRepositoryJDBCPostgresImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/SaveUserServlet")
public class SaveUserServlet extends HttpServlet {
    private UserRepositoryJDBCPostgresImpl repo;

    public void init() throws ServletException {
        super.init();
        try {
            Connection conn = DBCPDataSource.getConnection();
        } catch (SQLException e) {
            throw new DataBaseConnectionException(e);
        }
        repo = new UserRepositoryJDBCPostgresImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickName = request.getParameter("nick_name");
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");

        UserEntity user = new UserEntity(0L, nickName, fullName, email);
        repo.save(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/UserListServlet");
        dispatcher.forward(request, response);
    }
}
