package model.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bo.CategoryBO;

@WebServlet("/EditCategory")
public class EditCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCategoryStr = request.getParameter("idCategory");
        
        if (idCategoryStr != null && !idCategoryStr.isEmpty()) {
            try {
                int idCategory = Integer.parseInt(idCategoryStr);
                CategoryBO categoryBO = new CategoryBO();
                Category category = categoryBO.findCategory(idCategory);
                
                if (category != null) {
                    request.setAttribute("category", category);
                    request.getRequestDispatcher("/edit_category.jsp").forward(request, response);
                } else {
                    response.getWriter().println("Category not found!");
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while processing your request.");
            }
        } else {
            response.getWriter().println("Invalid category ID!");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idCategoryStr = request.getParameter("idCategory");
        String nameCategory = request.getParameter("nameCategory");

        if (idCategoryStr != null && !idCategoryStr.isEmpty()) {
            try {
                int idCategory = Integer.parseInt(idCategoryStr);
                Category category = new Category();
                category.setIdCategory(idCategory);
                category.setNameCategory(nameCategory);

                CategoryBO categoryBO = new CategoryBO();
                int result = categoryBO.updateCategory(category);

                if (result != 0) {
                    response.sendRedirect(request.getContextPath() + "/ManageCategory");
                } else {
                    response.getWriter().println("Update failed!");
                }
            } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred while processing your request.");
            }
        } else {
            response.getWriter().println("Invalid category ID!");
        }
    }
}
