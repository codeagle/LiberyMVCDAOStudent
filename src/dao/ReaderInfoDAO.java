package dao;

import java.util.ArrayList;

import vo.ReaderInfo;


public interface ReaderInfoDAO {
	//��ѯȫ����������
		public ArrayList findAllReaderInfo(ReaderInfo readerinfo)throws Exception;
		//��Ӷ�������
		public boolean doCreate(ReaderInfo readerinfo)throws Exception;
		//�޸Ķ�������
		public boolean doUpdate(ReaderInfo readerinfo)throws Exception;
		//ɾ����������
		public boolean doDelete(int readerid)throws Exception;
		//����ָ��readerid��ѯ��������
		public ReaderInfo findReaderInfoById(int readerid)throws Exception;
		
}
