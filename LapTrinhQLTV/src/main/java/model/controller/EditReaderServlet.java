package model.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Reader;
import model.bo.ReaderBO;

@WebServlet("/EditReader")
public class EditReaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idReaderStr = request.getParameter("idReader");

        if (idReaderStr != null && !idReaderStr.isEmpty()) {
            try {
                String idReader = idReaderStr;
                ReaderBO readerBO = new ReaderBO();
                Reader reader = readerBO.findReader(idReader);

                if (reader != null) {
                    request.setAttribute("reader", reader);
                    request.getRequestDispatcher("/edit_reader.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Reader not found!");
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while processing your request.");
            }
        } else {
            response.getWriter().println("Invalid reader ID!");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idReaderStr = request.getParameter("idReader");
        String nameReader = request.getParameter("nameReader");
        String identity = request.getParameter("identity");
        String telReader = request.getParameter("telReader");

        if (idReaderStr != null && !idReaderStr.isEmpty()) {
            try {
                int idReader = Integer.parseInt(idReaderStr);
                Reader reader = new Reader();
                reader.setIdReader(idReader);
                reader.setNameReader(nameReader);
                reader.setIdentity(identity);
                reader.setTelReader(telReader);

                ReaderBO readerBO = new ReaderBO();
                int result = readerBO.updateReader(reader);

                if (result != 0) {
                    response.sendRedirect(request.getContextPath() + "/ManageReader");
                } else {
                    response.getWriter().println("Update failed!");
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while processing your request.");
            }
        } else {
            response.getWriter().println("Invalid reader ID!");
        }
    }
}
