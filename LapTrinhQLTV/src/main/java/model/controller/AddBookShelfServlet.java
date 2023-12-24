package model.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.BookShelf;
import model.bo.BookShelfBO;

@WebServlet("/AddBookShelf")
public class AddBookShelfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookShelfBO bookShelfBO = new BookShelfBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to your add_book_shelf.jsp page or handle the GET request as needed
        // (for example, showing a form to add a book shelf)
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nameBookShelf = request.getParameter("nameBookShelf");
        BookShelf newBookShelf = new BookShelf();
        newBookShelf.setNameBookShelf(nameBookShelf);

        try {
            int result = bookShelfBO.insertBookShelf(newBookShelf);
            if (result != 0) {
                // Insert thành công
                response.sendRedirect(request.getContextPath() + "/ManageBookShelf");
            } else {
                // Insert thất bại
                String errorString = "Thêm thất bại";
                request.setAttribute("errorString", errorString);
                // Forward hoặc redirect tới trang thông báo lỗi
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ nếu cần thiết
        }
    }
}
