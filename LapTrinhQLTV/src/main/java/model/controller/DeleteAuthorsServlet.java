package model.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.AuthorsBO;


/**
 * Servlet implementation class DeleteAuthors
 */
@WebServlet("/DeleteAuthors")
public class DeleteAuthorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthorsBO authorsBO = new AuthorsBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAuthorsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idAuthors = Integer.parseInt(request.getParameter("idAuthors"));
		boolean result;
		try {
			result = authorsBO.deleteAuthors(idAuthors);
			System.out.println("Ket qua"+result);
			if (result == true) {
				request.setAttribute("errorString", "Đã xóa thành công");
			} else {
				System.out.println("DeleteAuthorsServlet - doGet() called");
				request.setAttribute("errorString", "Lỗi cơ sở dữ liệu");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ManageAuthors");
//		dispatcher.forward(request, response);
		response.sendRedirect("ManageAuthors");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
