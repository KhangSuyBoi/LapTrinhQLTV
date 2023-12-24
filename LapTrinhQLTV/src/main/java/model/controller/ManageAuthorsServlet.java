package model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Authors;
import model.bo.AuthorsBO;

@WebServlet("/ManageAuthors")
public class ManageAuthorsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuthorsBO authorsBO = new AuthorsBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<Authors> authorsList = authorsBO.list();
            // Gửi danh sách tác giả về cho trang JSP hiển thị
            request.setAttribute("authorsList", authorsList);
            request.getRequestDispatcher("manage_authors.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            // Xử lý các ngoại lệ nếu cần
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý các thao tác POST nếu cần
    }
}
