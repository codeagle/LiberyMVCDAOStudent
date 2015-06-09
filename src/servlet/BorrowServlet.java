package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.BookInfo;
import vo.Borrow;
import vo.ReaderInfo;
import dao.factory.DAOFactory;

public class BorrowServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=gb18030");
		request.setCharacterEncoding("gb18030");
		ReaderInfo readerInfo=new ReaderInfo();
		if(request.getParameter("readerNo")==null){
			 
			try {
				
				ArrayList allBorrowReader = (ArrayList)DAOFactory.getBorrowReaderDAOInstance().findAllBorrowReader(readerInfo);
				request.getSession().setAttribute("allBorrowReader", allBorrowReader);
				request.getRequestDispatcher("book_borrow.jsp").forward(request, response);
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{	
			String readerno =request.getParameter("readerNo");
		readerInfo.setReaderno(request.getParameter("readerNo"));
		try {
			Borrow borrow= new Borrow();
			int  countnum=DAOFactory.getBorrowBookDAOInstance().countBookNumber(readerno).getCountnum();
			request.getSession().setAttribute("countnum", countnum);
		ArrayList allBorrowReader=(ArrayList)DAOFactory.getBorrowReaderDAOInstance().findAllBorrowReader(readerInfo);
		ArrayList allBorrowBook =(ArrayList)DAOFactory.getBorrowBookDAOInstance().findAllBorrowBook(borrow, readerno);
		request.getSession().setAttribute("allBorrowReader", allBorrowReader);
		request.getSession().setAttribute("allBorrowBook", allBorrowBook);
		if(!request.getParameter("inputkey").trim().isEmpty()){
			BookInfo bookinfo=DAOFactory.getBorrowBookDAOInstance().findBookByISBN(request.getParameter("inputkey"));
			borrow.setReaderno(readerno);
			borrow.setReadername(request.getParameter("readername"));
			borrow.setIsbn(request.getParameter("inputkey"));
			borrow.setBookname(bookinfo.getBookname());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置借阅日期格式为系统默认时间
			borrow.setBorrowdate(df.format(new Date()));
			DAOFactory.getBorrowBookDAOInstance().insertBorrowBook(borrow);
			countnum=DAOFactory.getBorrowBookDAOInstance().countBookNumber(readerno).getCountnum();
			request.getSession().setAttribute("countnum", countnum);
			allBorrowBook =(ArrayList)DAOFactory.getBorrowBookDAOInstance().findAllBorrowBook(borrow, readerno);
			request.getSession().setAttribute("allBorrowBook", allBorrowBook);
			request.getRequestDispatcher("book_borrow.jsp").forward(request, response);
			return;
			
		}
		request.getRequestDispatcher("book_borrow.jsp").forward(request, response);
		return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
