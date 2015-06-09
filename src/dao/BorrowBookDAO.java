package dao;

import java.util.ArrayList;

import vo.BookInfo;
import vo.Borrow;

public interface BorrowBookDAO {
	public ArrayList findAllBorrowBook(Borrow borrow,String readerno)throws Exception;
	//向借阅表中插入数据
	public boolean insertBorrowBook(Borrow borrow)throws Exception;
	public BookInfo findBookByISBN(String isbn)throws Exception;
	//归还图书
	public boolean backBookById(int borrowid,String backdate) throws Exception;
	//续借图书
	public boolean renewBookById(Borrow borrow)throws Exception;
	//查找图书是否可以续借
	public ArrayList findBorrowBookNoYes(Borrow borrow,String readerno)throws Exception;
	 //统计借阅的图书总数
	public Borrow countBookNumber(String	 readerno)throws Exception;
}
