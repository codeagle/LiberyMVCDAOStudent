package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.BookCase;
import vo.BookType;
import dao.BookCaseDAO;
import dao.dbc.DBConnection;

public class BookCaseDAOImpl implements BookCaseDAO {
	private PreparedStatement pstmt=null;
	private ResultSet rs =null;
	boolean flag=false;
	DBConnection dbc = new DBConnection();
	private Connection conn=dbc.getConnection();

	public ArrayList findAllBookCase(BookCase bookcase) throws Exception {
		ArrayList allBookCase = new ArrayList();
		try {
			String sql="select * from bookcase";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				bookcase=new BookCase();
				bookcase.setCaseid(rs.getInt("caseid"));
				bookcase.setCasename(rs.getString("casename"));
				allBookCase.add(bookcase);
			}
			rs.close();
			pstmt.close();
			dbc.closed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allBookCase;
	}

	@Override
	public boolean doCreate(BookCase bookcase) throws Exception {
			try {
				String sql="insert into BookCase(casename) values(?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, bookcase.getCasename());
				
				int count=pstmt.executeUpdate();
				if(count>0){
					flag=true;
				}
				pstmt.close();
				dbc.closed();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(BookCase bookcase) throws Exception {
		try {
			//conn=dbc.getConnection();
			String sql="update bookcase set casename=? where caseid=?";		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bookcase.getCasename());
			pstmt.setInt(2, bookcase.getCaseid());
			int count=pstmt.executeUpdate();
			if(count>0){
				flag=true;
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return flag;
	}

	@Override
	public boolean doDelete(int caseid) throws Exception {
		try {
			conn=dbc.getConnection();
			String sql="delete from BookCase where caseid=? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, caseid);
			int count=pstmt.executeUpdate();
			if(count>0){
				flag=true;
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		return flag;
	}

	@Override
	public BookCase findBookCaseById(int caseid) throws Exception {
		BookCase bc= new BookCase();
		try {
			
			String sql="select * from bookcase where caseid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, caseid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bc.setCaseid(rs.getInt("caseid"));
				bc.setCasename(rs.getString("casename"));
				
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		
		return bc;
	}

}
