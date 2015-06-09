package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.BookInfo;
import vo.Borrow;
import dao.BorrowBookDAO;
import dao.dbc.DBConnection;

public class BorrowBookDAOImpl implements BorrowBookDAO {
	private PreparedStatement pstmt=null;
	private ResultSet rs =null;
	boolean flag=false;
	DBConnection dbc = new DBConnection();
	private Connection conn=dbc.getConnection();
	
	//����ͼ��
	public boolean insertBorrowBook(Borrow borrow) throws Exception {
		try {
			String sql="insert into borrow(isbn,readerno,readername,borrowdate,backdate) values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, borrow.getIsbn());
			pstmt.setString(2, borrow.getReaderno() );
			pstmt.setString(3, borrow.getReadername());
			pstmt.setString(4, borrow.getBorrowdate());
			pstmt.setString(5, borrow.getBackdate());
			int count = pstmt.executeUpdate();
			if(count >0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//��ѯ��������δ�黹��ͼ��
	@Override
	public ArrayList findAllBorrowBook(Borrow borrow,String readerno) throws Exception {
		ArrayList allBorrowBook = new ArrayList();
		try {
			String sql="select bi.bookname,bi.casename,borrowid,b.isbn,b.readerNo,b.readername,CONVERT(varchar(12) , borrowdate, 111) as borrowdate , CONVERT(varchar(12) , backdate, 111 ) as backdate,renew, CONVERT(varchar(12) , borrowdate+30 , 111 ) as orderdate from bookinfo bi,borrow b,readerinfo r where r.readerno=b.readerNo and bi.isbn=b.isbn and backdate is null and b.readerNo=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, readerno);
			rs=pstmt.executeQuery();
			while(rs.next()){
				 borrow =new Borrow();
				 borrow.setBorrowid(rs.getInt("borrowid"));
				borrow.setBookname(rs.getString("bookname"));
				borrow.setBorrowdate(rs.getString("borrowdate"));
				borrow.setOrderdate(rs.getString("orderdate"));
				borrow.setIsbn(rs.getString("isbn"));
				borrow.setCasename(rs.getString("casename"));
				allBorrowBook.add(borrow);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allBorrowBook;
	}
	//ͨ��ISBN����ͼ��
	@Override
	public BookInfo findBookByISBN(String isbn) throws Exception {
		BookInfo bookinfo = new BookInfo();
		try {
			String sql ="select * from bookinfo where isbn=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, isbn);
			rs=pstmt.executeQuery();
			while(rs.next()){
				bookinfo = new BookInfo();
				bookinfo.setBookname(rs.getString("bookname"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookinfo;
	}
	//�黹ͼ��
	@Override
	public boolean backBookById(int borrowid,String backdate) throws Exception {
		try {
			String sql="update  Borrow set backdate=? where borrowid=? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, backdate);
			pstmt.setInt(2, borrowid);
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
	//
	/**
	 * ���谴ť���ܣ�ʵ�����蹦��,
	 * ʵ��ÿ�����ں���ʱ����ֻ��������һ��
	 * ���������״̬��Ϊ����
	 */
	@Override
	public boolean renewBookById(Borrow borrow) throws Exception {
		try {
			String sql="update borrow set borrowdate=?,renew='��' where borrowid=? and renew='��' ";		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, borrow.getBorrowdate());
			pstmt.setInt(2, borrow.getBorrowid());
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

	/**
	 * ��ѯ�Ƿ���������ͼ�顣
	 * ���������� 
	 * 		������״̬Ϊ���ǡ�
	 * 		��δ�黹
	 *  	�۽���ʱ����30�ڣ���û�г��ڣ�
	 */		
	@Override
	public ArrayList findBorrowBookNoYes(Borrow borrow, String readerno)
			throws Exception {
		ArrayList allBorrowBook = new ArrayList();
		try {
			String sql="select bi.bookname,bi.casename,borrowid,b.isbn,b.readerNo,b.readername,CONVERT(varchar(12) , borrowdate, 111) as borrowdate , CONVERT(varchar(12) , backdate, 111 ) as backdate,renew, CONVERT(varchar(12) , borrowdate+30 , 111 ) as orderdate "
					+ "from bookinfo bi,borrow b,readerinfo r where r.readerno=b.readerNo and backdate is  null"
					+ " and bi.isbn=b.isbn and renew='��' and b.readerNo=? and  DATEDIFF(dd,borrowdate,GETDATE())<=30";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, readerno);
			rs=pstmt.executeQuery();
			while(rs.next()){
				 borrow =new Borrow();
				 borrow.setBorrowid(rs.getInt("borrowid"));
				borrow.setBookname(rs.getString("bookname"));
				borrow.setBorrowdate(rs.getString("borrowdate"));
				borrow.setOrderdate(rs.getString("orderdate"));
				borrow.setIsbn(rs.getString("isbn"));
				borrow.setCasename(rs.getString("casename"));
				allBorrowBook.add(borrow);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allBorrowBook;
	}
	/**
	 * ͳ�ƽ���ͼ�������
	 */
	@Override
	public Borrow countBookNumber(String readerno) throws Exception {
		Borrow borrow=new Borrow();
		try {
			String sql ="select count(*) as countnum from borrow where readerNo=? and backdate is null";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, readerno);
			rs=pstmt.executeQuery();
			while(rs.next()){
				borrow= new Borrow();
				borrow.setCountnum(rs.getInt("countnum"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return borrow;
	}
}
