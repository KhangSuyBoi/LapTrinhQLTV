package model.controller;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Reader;
import model.bo.ReaderBO;



/**
 * Servlet implementation class AddReader
 */
@WebServlet("/AddReader")
public class AddReaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReaderBO ReaderBO = new ReaderBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Hiển thị form thêm danh mục khi nhận yêu cầu GET
        RequestDispatcher dispatcher = request.getRequestDispatcher("/add_reader.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nameReader = request.getParameter("nameReader");
        String identity = request.getParameter("identity");
        String telReader = request.getParameter("telReader");

        Reader reader = new Reader();
        reader.setNameReader(nameReader);
        reader.setIdentity(identity);
        reader.setTelReader(telReader);

        try {
            int result = ReaderBO.insertReader(reader);
            if (result > 0) {
                // Nếu thêm thành công, có thể chuyển hướng đến trang khác hoặc hiển thị thông báo thành công
                response.sendRedirect("ManageReader"); // Chuyển hướng đến trang quản lý danh mục
            } else {
                // Xử lý khi thêm không thành công, có thể hiển thị thông báo lỗi
                String errorMessage = "Thêm danh mục không thành công";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/add_reader.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            // Xử lý exception nếu có
            e.printStackTrace();
            String errorMessage = "Đã xảy ra lỗi khi thêm danh mục";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/add_reader.jsp");
            dispatcher.forward(request, response);
        }
    }
}
