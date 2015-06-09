package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.BookInfo;
import vo.BookType;
import dao.BookInfoDAO;
import dao.dbc.DBConnection;

public class BookInfoDAOImpl implements BookInfoDAO {
	private PreparedStatement pstmt=null;
	private ResultSet rs =null;
	boolean flag=false;
	DBConnection dbc = new DBConnection();
	private Connection conn=dbc.getConnection();
	
	public ArrayList findAllBookInfo(BookInfo bookinfo) throws Exception {
		ArrayList allBookInfo = new ArrayList();
		try{
		String sql="select * from bookinfo";
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		while(rs.next()){
			bookinfo = new BookInfo();
			bookinfo.setBookid(rs.getInt("bookid"));
			bookinfo.setBookname(rs.getString("bookname"));
			bookinfo.setAuthor(rs.getString("author"));
			bookinfo.setCasename(rs.getString("casename"));
			bookinfo.setIsbn(rs.getString("isbn"));
			bookinfo.setPrice(rs.getDouble("price"));
			bookinfo.setPubname(rs.getString("pubname"));
			bookinfo.setTypename(rs.getString("typename"));
			allBookInfo.add(bookinfo);
		}
		rs.close();
		pstmt.close();
		dbc.closed();
		}catch(Exception e){
			e.printStackTrace();
		}
		return allBookInfo;
	}


	public boolean doCreate(BookInfo bookinfo) throws Exception {
		try {
			conn=dbc.getConnection();
			String sql="insert into BookInfo(bookname,typename,author,pubname,isbn,price,casename)  values(?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bookinfo.getBookname());
			pstmt.setString(2, bookinfo.getTypename());
			pstmt.setString(3, bookinfo.getAuthor());
			pstmt.setString(4, bookinfo.getPubname());
			pstmt.setString(5, bookinfo.getIsbn());
			pstmt.setDouble(6, bookinfo.getPrice());
			pstmt.setString(7, bookinfo.getCasename());
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

	
	public boolean doUpdate(BookInfo bookinfo) throws Exception {
		try{
		String sql="update bookinfo set bookname=?,typename=?,author=?,pubname=?,isbn=?,price=?,casename=? where bookid=?";		
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, bookinfo.getBookname());
		pstmt.setString(2, bookinfo.getTypename());
		pstmt.setString(3, bookinfo.getAuthor());
		pstmt.setString(4, bookinfo.getPubname());
		pstmt.setString(5, bookinfo.getIsbn());
		pstmt.setDouble(6, bookinfo.getPrice());
		pstmt.setString(7, bookinfo.getCasename());
		pstmt.setInt(8, bookinfo.getBookid());
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

	
	public boolean doDelete(int bookid) throws Exception {
		try {
			String sql="delete from BookInfo where bookid=? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
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


	public BookInfo findBookInfoById(int bookid) throws Exception {
		BookInfo bookinfo= new BookInfo();
		try {
			
			String sql="select * from BookInfo where bookid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bookinfo.setBookid(rs.getInt("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setCasename(rs.getString("casename"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setPrice(rs.getDouble("price"));
				bookinfo.setPubname(rs.getString("pubname"));
				bookinfo.setTypename(rs.getString("typename"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		
		return bookinfo;
	}


	@Override
	public BookInfo findBookInfoByISBN(String isbn) throws Exception {
		BookInfo bookinfo= new BookInfo();
		try {
			
			String sql="select * from BookInfo where isbn=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bookinfo.setBookid(rs.getInt("bookid"));
				bookinfo.setBookname(rs.getString("bookname"));
				bookinfo.setAuthor(rs.getString("author"));
				bookinfo.setCasename(rs.getString("casename"));
				bookinfo.setIsbn(rs.getString("isbn"));
				bookinfo.setPrice(rs.getDouble("price"));
				bookinfo.setPubname(rs.getString("pubname"));
				bookinfo.setTypename(rs.getString("typename"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		
		return bookinfo;
	}

}
