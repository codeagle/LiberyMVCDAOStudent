package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Borrow;
import vo.ReaderInfo;
import dao.BorrowReaderDAO;
import dao.dbc.DBConnection;

public class BorrowReaderDAOImpl implements BorrowReaderDAO {
	private PreparedStatement pstmt=null;
	private ResultSet rs =null;
	boolean flag=false;
	DBConnection dbc = new DBConnection();
	private Connection conn=dbc.getConnection();
	@Override
	public ArrayList findAllBorrowReader(ReaderInfo readerinfo) throws Exception {
		ArrayList allBorrowReader = new ArrayList();
		try {
			String sql = "select r.readerno,readername,r.rtypename,rt.number,idcard from readerinfo r,readertype rt where r.rtypename=rt.rtypename and readerno=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, readerinfo.getReaderno());
			rs=pstmt.executeQuery();
			while(rs.next()){
				readerinfo = new ReaderInfo();
				readerinfo.setReaderno(rs.getString("readerno"));
				readerinfo.setReadername(rs.getString("readername"));
				readerinfo.setRtypename(rs.getString("rtypename"));
				readerinfo.setIdcard(rs.getString("idcard"));
				readerinfo.setNumber(rs.getInt("number"));
				allBorrowReader.add(readerinfo);
			}
			rs.close();
			pstmt.close();
			dbc.closed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allBorrowReader;
	}



}
