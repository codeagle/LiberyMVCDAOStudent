package dao;

import java.util.ArrayList;

import vo.Borrow;
import vo.ReaderInfo;

public interface BorrowReaderDAO {
	//��ѯȫ������ͼ�鵵��
	public ArrayList findAllBorrowReader(ReaderInfo readerinfo)throws Exception;
	
}
