package dao;

import java.util.ArrayList;

import vo.BookType;

public interface BookTypeDAO {
	//��ѯȫ��ͼ������
	public ArrayList findAllBookType(BookType booktype)throws Exception;
	//���ͼ��������Ϣ
	public boolean doCreate(BookType booktype)throws Exception;
	//�޸�ͼ��������Ϣ
	public boolean doUpdate(BookType booktype)throws Exception;
	//ɾ��ͼ��������Ϣ
	public boolean doDelete(int typeid)throws Exception;
	//����ָ��typeid��ѯͼ��������Ϣ
	public BookType findBookTypeById(int typeid)throws Exception;
}