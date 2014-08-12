package com.augmentum.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestForwardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TestForwardServlet() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> testList = new ArrayList<String>();
        testList.add("item4");
        testList.add("item5");
        testList.add("item6");

        request.setAttribute("testList", testList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/testForward.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        doGet(request, response);
    }
}
