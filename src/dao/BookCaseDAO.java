package dao;

import java.util.ArrayList;

import vo.BookCase;
public interface BookCaseDAO {
	//查询全部书架名称
	public ArrayList findAllBookCase(BookCase bookcase)throws Exception;
	//添加书架信息
	public boolean doCreate(BookCase bookcase)throws Exception;
	//修改书架信息
	public boolean doUpdate(BookCase bookcase)throws Exception;
	//删除书架类型信息
	public boolean doDelete(int caseid)throws Exception;
	//根据指定caseid查询书架信息
	public BookCase findBookCaseById(int caseid)throws Exception;
}
