package model.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.descriptor.web.MultipartDef;

import model.bean.Authors;
import model.bean.Book;
import model.bean.BookShelf;
import model.bean.Category;
import model.bo.AuthorsBO;
import model.bo.BookBO;
import model.bo.BookShelfBO;
import model.bo.CategoryBO;


/**
 * Servlet implementation class AddBook
 */
@MultipartConfig
@WebServlet("/AddBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryBO categoryBO = new CategoryBO();
	private AuthorsBO authorsBO = new AuthorsBO();
	private BookShelfBO bookshelfBO = new BookShelfBO();
	private BookBO bookBO = new BookBO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    String errorString = null;
		    ArrayList<Category> CategoryList = null;
		    ArrayList<BookShelf> BookShelfList = null;
		    ArrayList<Authors> AuthorsList = null;

		    try {
		    	
		    	CategoryList = categoryBO.list();
		        System.out.print(CategoryList);
		        BookShelfList = bookshelfBO.getAllBookShelf();
		        System.out.print(BookShelfList);
		        AuthorsList = authorsBO.list();
		        System.out.print(AuthorsList);
		        
		    } catch (Exception e) {
		        e.printStackTrace();
		        errorString = e.getMessage();
		    }

		    request.setAttribute("errorString", errorString);
		    request.setAttribute("categoryList", CategoryList);
		    request.setAttribute("BookShelfList", BookShelfList);
		    request.setAttribute("AuthorsList", AuthorsList);
		    request.getSession().setAttribute("Check", "AddBook");

		    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/add_book.jsp");
		    dispatcher.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String nameBook = request.getParameter("nameBook");
		String idCategoryString = request.getParameter("category");
		Integer idCategory = null;

		try {
		    idCategory = Integer.parseInt(idCategoryString);
		} catch (NumberFormatException e) {
		    // Xử lý lỗi nếu không thể chuyển đổi thành Integer
		    e.printStackTrace();
		}		String count = request.getParameter("count");
		Part file = request.getPart("fileImage");
//		String path = getServletContext().getRealPath("/") + "Resources/images/";
		String savePath = getServletContext().getRealPath("/") + "Resources\\img\\products";
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String fileName = extractfilename(file);
		file.write(savePath + File.separator + fileName);
//		String filePath = savePath + File.separator + fileName;
		Book book = new Book();
		book.setNameBook(nameBook);
		Category category = new Category();
		try {
			category = categoryBO.findCategory(idCategory);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		book.setCategory(category);
		book.setAmount(count);
		book.setImage(fileName);
		try {
			int result = bookBO.insertBook(book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("errorString", "Thêm sách thành công");
		response.sendRedirect("/ManageBook");
	}

	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}

}
