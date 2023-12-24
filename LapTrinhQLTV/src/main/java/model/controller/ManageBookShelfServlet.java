package model.controller;


import model.bean.BookShelf;
import model.bo.BookBO;
import model.bo.BookShelfBO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageBook
 */
@WebServlet("/ManageBookShelf")
public class ManageBookShelfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookShelfBO bookShelfBO = new BookShelfBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorString = null;
        ArrayList<BookShelf> list = null;
        try {
            list = bookShelfBO.getAllBookShelf();
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("BookShelfList", list);
        request.getSession().setAttribute("Check", "ManageBookShelf");

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/manage_bookshelf.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
