package dao;

import java.util.ArrayList;

import vo.BookCase;
public interface BookCaseDAO {
	//��ѯȫ���������
	public ArrayList findAllBookCase(BookCase bookcase)throws Exception;
	//��������Ϣ
	public boolean doCreate(BookCase bookcase)throws Exception;
	//�޸������Ϣ
	public boolean doUpdate(BookCase bookcase)throws Exception;
	//ɾ�����������Ϣ
	public boolean doDelete(int caseid)throws Exception;
	//����ָ��caseid��ѯ�����Ϣ
	public BookCase findBookCaseById(int caseid)throws Exception;
}
