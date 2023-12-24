package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Authors;
import model.bean.Book;
import model.bean.BookShelf;
import model.bean.Category;
import model.bo.AuthorsBO;
import model.bo.BookShelfBO;
import model.bo.CategoryBO;
import model.bo.ReaderBO;

public class BookDAO {
	Connection conn = null;
	Statement st = null;
	PreparedStatement preSt = null;
	CategoryBO categoryBO = new CategoryBO();
	AuthorsBO authorsBO = new AuthorsBO();
	BookShelfBO bookShelfBO = new BookShelfBO();
	
	public Book findBook(String idBook)throws SQLException, ClassNotFoundException {
		if(conn==null)
		conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from book where idBook=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, idBook);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String nameBook = rs.getString("nameBook");
			Integer idCategory = rs.getInt("idCategory");
			Integer idAuthors = rs.getInt("idAuthors");
			Integer idBookShelf = rs.getInt("idBookShelf");
			Date day = rs.getDate("day");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDay =dateFormat.format(day);
			Category category = new Category();
			try {
				category = categoryBO.findCategory(idCategory);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BookShelf bookShelf = new BookShelf();
			try {
				bookShelf = bookShelfBO.findBookShelf(idBookShelf);
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			Authors authors = new Authors();
			try {
				authors = authorsBO.findAuthors(idAuthors);
			} catch (ClassNotFoundException | SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			String amount = rs.getString("amount");
			String image = rs.getString("image");
			Book book = new Book();
			book.setIdBook(idBook);
			book.setNameBook(nameBook);
			book.setCategory(category);
			book.setBookShelf(bookShelf);
			book.setAuthors(authors);
			book.setAmount(amount);
			book.setImage(image);
			book.setDay(strDay);
		}
		return null;
	}
	public int insertBook(Book book) throws SQLException, ClassNotFoundException{
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		try {
			st = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		int result = 0;
		String sql = "insert into book(nameBook, idCategory, idBookShelf, idAuthors, amount, image) values (?,?,?,?,?,?)";
		preSt = conn.prepareStatement(sql);
		preSt.setString(1, book.getNameBook());
		preSt.setString(2, Integer.toString(book.getCategory().getIdCategory()));
		preSt.setString(3, Integer.toString(book.getBookShelf().getIdBookShelf()));
		preSt.setString(4, Integer.toString(book.getAuthors().getIdAuthors()));
		preSt.setString(5, book.getAmount());
		preSt.setString(6, book.getImage());
		result = preSt.executeUpdate();
		System.out.println("Ketqua" + result);
		return result;
	}
	public ArrayList<Book> getAllBook() throws SQLException, ClassNotFoundException{
		ArrayList<Book> list = new ArrayList();
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Select * from book order by day desc";
		PreparedStatement pstm= conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String idBook = rs.getString("idBook");
			String nameBook = rs.getString("nameBook");
			Integer idCategory = rs.getInt("idCategory");
			Integer idAuthors = rs.getInt("idAuthors");
			Integer idBookShelf = rs.getInt("idBookShelf");
			Date day = rs.getDate("day");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDay =dateFormat.format(day);
			Category category = new Category();
			try {
				category = categoryBO.findCategory(idCategory);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BookShelf bookShelf = new BookShelf();
			try {
				bookShelf = bookShelfBO.findBookShelf(idBookShelf);
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			Authors authors = new Authors();
			try {
				authors = authorsBO.findAuthors(idAuthors);
			} catch (ClassNotFoundException | SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			String amount = rs.getString("amount");
			String image = rs.getString("image");
			Book book = new Book();
			book.setIdBook(idBook);
			book.setNameBook(nameBook);
			book.setCategory(category);
			book.setBookShelf(bookShelf);
			book.setAuthors(authors);
			book.setAmount(amount);
			book.setImage(image);
			book.setDay(strDay);
			list.add(book);
		}
		return list;
	}
	public ArrayList<Book> getSearchBook(String nameBookSearch) throws SQLException, ClassNotFoundException{
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		ArrayList<Book> list = new ArrayList();
		String sql = "Select * from book where nameBook like '%\"+nameBookSearch+\"%';";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String idBook = rs.getString("idBook");
			String nameBook = rs.getString("nameBook");
			Integer idCategory = rs.getInt("idCategory");
			Integer idAuthors = rs.getInt("idAuthors");
			Integer idBookShelf = rs.getInt("idBookShelf");
			Date day = rs.getDate("day");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDay =dateFormat.format(day);
			Category category = new Category();
			try {
				category = categoryBO.findCategory(idCategory);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BookShelf bookShelf = new BookShelf();
			try {
				bookShelf = bookShelfBO.findBookShelf(idBookShelf);
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			Authors authors = new Authors();
			try {
				authors = authorsBO.findAuthors(idAuthors);
			} catch (ClassNotFoundException | SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			String amount = rs.getString("amount");
			String image = rs.getString("image");
			Book book = new Book();
			book.setIdBook(idBook);
			book.setNameBook(nameBook);
			book.setCategory(category);
			book.setBookShelf(bookShelf);
			book.setAuthors(authors);
			book.setAmount(amount);
			book.setImage(image);
			book.setDay(strDay);
			list.add(book);
		}
		return list;
	}
	public int updateBook(Book book) throws ClassNotFoundException, SQLException {
		int rs = 0;
		if(conn == null) {
			conn = ConnectDatabase.getMySQLConnection();
			String sql = "update book set nameBook = ?, idCategory = ?, idBookShelf = ?, idAuthors = ?, amount = ?, image = ? where idBook = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			preSt.setString(1, book.getNameBook());
			preSt.setString(2, Integer.toString(book.getCategory().getIdCategory()));
			preSt.setString(3, Integer.toString(book.getBookShelf().getIdBookShelf()));
			preSt.setString(4, Integer.toString(book.getAuthors().getIdAuthors()));
			preSt.setString(5, book.getAmount());
			preSt.setString(6, book.getImage());
			preSt.setString(7, book.getIdBook());
			rs = pstm.executeUpdate();
		}
		return rs;
	}
	public int deleteAllBook() throws SQLException, ClassNotFoundException{
		int result = 0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "Delete From Book";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
		result = pstm.executeUpdate();
		return result;
	}
	public int deleteBook(String idBook) throws SQLException, ClassNotFoundException{
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		try {
		String sql = "delete from book where idBook = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, idBook);
		return pstm.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		} 
	}
	public int deleteBookCategory(Integer idCategory) throws SQLException, ClassNotFoundException{
		int result = 0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "delete from book where idCategory = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,idCategory);
		result = pstm.executeUpdate();
		return result;
	}
	public int deleteBookAuthors(int idAuthors) throws SQLException, ClassNotFoundException{
		int result = 0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "delete from book where idAuthors = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,idAuthors);
		result = pstm.executeUpdate();
		return result;
	}
	public int deleteBook_BookShelf(String idBookShelf) throws SQLException, ClassNotFoundException{
		int result = 0;
		if(conn == null)
			conn = ConnectDatabase.getMySQLConnection();
		String sql = "delete from book where idBookShelf = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,idBookShelf);
		result = pstm.executeUpdate();
		return result;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BookDAO bookDAO = new BookDAO();
		bookDAO.getAllBook();
		System.out.println(bookDAO);
	}
}
