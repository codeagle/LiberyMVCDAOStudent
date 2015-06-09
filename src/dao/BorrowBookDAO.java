package dao;

import java.util.ArrayList;

import vo.BookInfo;
import vo.Borrow;

public interface BorrowBookDAO {
	public ArrayList findAllBorrowBook(Borrow borrow,String readerno)throws Exception;
	//����ı��в�������
	public boolean insertBorrowBook(Borrow borrow)throws Exception;
	public BookInfo findBookByISBN(String isbn)throws Exception;
	//�黹ͼ��
	public boolean backBookById(int borrowid,String backdate) throws Exception;
	//����ͼ��
	public boolean renewBookById(Borrow borrow)throws Exception;
	//����ͼ���Ƿ��������
	public ArrayList findBorrowBookNoYes(Borrow borrow,String readerno)throws Exception;
	 //ͳ�ƽ��ĵ�ͼ������
	public Borrow countBookNumber(String	 readerno)throws Exception;
}
