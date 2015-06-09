package dao;

import java.util.ArrayList;

import vo.Borrow;
import vo.ReaderInfo;

public interface BorrowReaderDAO {
	//查询全部借阅图书档案
	public ArrayList findAllBorrowReader(ReaderInfo readerinfo)throws Exception;
	
}
