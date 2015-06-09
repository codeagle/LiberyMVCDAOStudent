package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.ReaderInfo;
import dao.ReaderInfoDAO;
import dao.dbc.DBConnection;

public class ReaderInfoDAOImpl implements ReaderInfoDAO {
	private PreparedStatement pstmt=null;
	private ResultSet rs =null;
	boolean flag=false;
	DBConnection dbc = new DBConnection();
	private Connection conn=dbc.getConnection();
	
	public ArrayList findAllReaderInfo(ReaderInfo readerinfo) throws Exception {
		ArrayList allReaderInfo = new ArrayList();
		try {
			String sql="select * from readerinfo";
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				readerinfo=new ReaderInfo();
				readerinfo.setEmail(rs.getString("email"));
				readerinfo.setIdcard(rs.getString("idcard"));
				readerinfo.setReaderid(rs.getInt("readerid"));
				readerinfo.setReadername(rs.getString("readername"));
				readerinfo.setReaderno(rs.getString("readerno"));
				readerinfo.setRtypename(rs.getString("rtypename"));
				readerinfo.setTel(rs.getString("tel"));
				allReaderInfo.add(readerinfo);
			}
			rs.close();
			pstmt.close();
			dbc.closed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 	allReaderInfo;
	}

	@Override
	public boolean doCreate(ReaderInfo readerinfo) throws Exception {
		try {
			String sql="insert into readerinfo(readerno,	rtypename,readername,idcard,tel,email) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, readerinfo.getReaderno());
			pstmt.setString(2, readerinfo.getRtypename());
			pstmt.setString(3, readerinfo.getReadername());
			pstmt.setString(4, readerinfo.getIdcard());
			pstmt.setString(5, readerinfo.getTel());
			pstmt.setString(6, readerinfo.getEmail());
			
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
	public boolean doUpdate(ReaderInfo readerinfo) throws Exception {
		try {
			//conn=dbc.getConnection();
			String sql="update readerinfo set readerno=?,	rtypename=?,readername=?,idcard=?,tel=?,email=? where readerid=?";		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, readerinfo.getReaderno());
			pstmt.setString(2, readerinfo.getRtypename());
			pstmt.setString(3, readerinfo.getReadername());
			pstmt.setString(4, readerinfo.getIdcard());
			pstmt.setString(5, readerinfo.getTel());
			pstmt.setString(6, readerinfo.getEmail());
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
	public boolean doDelete(int readerid) throws Exception {
		try {
			conn=dbc.getConnection();
			String sql="delete from readerinfo where readerid=? ";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, readerid);
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
	public ReaderInfo findReaderInfoById(int readerid) throws Exception {
		
		ReaderInfo readerinfo= new ReaderInfo();
		try {
			
			String sql="select * from readerinfo where readerid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, readerid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				readerinfo.setEmail(rs.getString("email"));
				readerinfo.setIdcard(rs.getString("idcard"));
				readerinfo.setReaderid(rs.getInt("readerid"));
				readerinfo.setReadername(rs.getString("readername"));
				readerinfo.setReaderno(rs.getString("readerno"));
				readerinfo.setRtypename(rs.getString("rtypename"));
				readerinfo.setTel(rs.getString("tel"));
				
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbc.closed();
		}
		
		return readerinfo;
	}


}
