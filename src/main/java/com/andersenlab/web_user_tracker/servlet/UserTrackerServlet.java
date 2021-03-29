package com.andersenlab.web_user_tracker.servlet;

import com.andersenlab.web_user_tracker.action.Action;
import com.andersenlab.web_user_tracker.action.AddAction;
import com.andersenlab.web_user_tracker.action.HomeAction;
import com.andersenlab.web_user_tracker.action.RemoveAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserTrackerServlet extends HttpServlet {

    private final String REQUEST_PARAMETER = "action";
    private final String PAGE_ADD = "add";
    private final String PAGE_HOME = "home";
    private final String PAGE_REMOVE = "remove";

    private final Map<String, Action> actionMap = new ConcurrentHashMap<>();

    @Override
    public void init() throws ServletException {
        actionMap.put(PAGE_ADD, new AddAction());
        actionMap.put(PAGE_HOME, new HomeAction());
        actionMap.put(PAGE_REMOVE, new RemoveAction());
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String actionKey = "home";
        actionMap.get(actionKey).execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String actionKey = request.getParameter(REQUEST_PARAMETER);
        actionMap.get(actionKey).execute(request, response);
    }

}
