package dao.impl;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.BookType;
import dao.BookTypeDAO;
import dao.dbc.DBConnection;

public class BookTypeDAOImpl implements BookTypeDAO {
	private PreparedStatement pstmt=null;
	private ResultSet rs =null;
	boolean flag=false;
	DBConnection dbc = new DBConnection();
	private Connection conn=dbc.getConnection();
	public ArrayList findAllBookType(BookType booktype) throws Exception {
		ArrayList allBookType = new ArrayList();
		try {
			
			String sql="select * from booktype";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				booktype = new BookType();
				booktype.setTypeid(rs.getInt("typeid"));
				booktype.setTypename(rs.getString("typename"));
				allBookType.add(booktype);
			}
			rs.close();
			pstmt.close();
			dbc.closed();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allBookType;
	}

	@Override
	public boolean doCreate(BookType booktype) throws Exception {
		try {
			conn=dbc.getConnection();
			String sql="insert into BookType(typename) values(?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, booktype.getTypename());
			
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
	public boolean doUpdate(BookType booktype) throws Exception {
		try {
			//conn=dbc.getConnection();
			String sql="update booktype set typename=? where typeid=?";		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, booktype.getTypename());
			pstmt.setInt(2, booktype.getTypeid());
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
	public boolean doDelete(int typeid) throws Exception {
		try {
			conn=dbc.getConnection();
			String sql="delete from BookType where typeid=? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, typeid);
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
	public BookType findBookTypeById(int typeid) throws Exception {
		BookType by = new BookType();
		try {
			
			String sql="select * from booktype where typeid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, typeid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				by.setTypeid(rs.getInt("typeid"));
				by.setTypename(rs.getString("typename"));
				
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		
		return by;
	}

}
