package dao;

import java.util.ArrayList;

import vo.BookInfo;

public interface BookInfoDAO {
	//��ѯȫ��ͼ�鵵��
	public ArrayList findAllBookInfo(BookInfo bookinfo)throws Exception;
	//���ͼ�鵵����Ϣ
	public boolean doCreate(BookInfo bookinfo)throws Exception;
	//�޸�ͼ�鵵����Ϣ
	public boolean doUpdate(BookInfo bookinfo)throws Exception;
	//ɾ��ͼ�鵵����Ϣ
	public boolean doDelete(int bookid)throws Exception;
	//����ָ��bookid��ѯͼ�鵵��
	public BookInfo findBookInfoById(int bookid)throws Exception;
	public BookInfo findBookInfoByISBN(String isbn)throws Exception;
}
