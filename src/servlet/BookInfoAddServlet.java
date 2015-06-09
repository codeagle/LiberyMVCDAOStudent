package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.factory.DAOFactory;
import vo.BookInfo;

public class BookInfoAddServlet extends HttpServlet {

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
		BookInfo bookinfo = new BookInfo();
		bookinfo.setBookname(request.getParameter("bookname"));
		bookinfo.setTypename(request.getParameter("typename"));
		bookinfo.setAuthor(request.getParameter("author"));
		bookinfo.setPubname(request.getParameter("publishing"));
		bookinfo.setIsbn(request.getParameter("isbn"));
		bookinfo.setPrice(Double.valueOf(request.getParameter("price")));
		bookinfo.setCasename(request.getParameter("casename"));
		try {
			if(DAOFactory.getBookInfoDAOInstance().doCreate(bookinfo)){
				request.getSession().setAttribute("bookinfo", bookinfo);
				request.getRequestDispatcher("BookInfoQueryAllServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
