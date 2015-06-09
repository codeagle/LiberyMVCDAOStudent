package dao.dbc;
import java.sql.*;
public class DBConnection {
	private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433; DatabaseName=LibraryManager";
    private static  final String userName = "sa";
    private static  final String password = "123456";
    private  Connection conn = null;
    boolean flag = false;
    
    /** 
     * @���� �������ݿ����� 
     * @����ֵ connection��ֵ 
     */
    public Connection getConnection() {
        try {
        	Class.forName(driver); 
        	conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
           System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
        }
        return conn;
    }
    
     /** 
     * @���� �ر����ݿ�����
     */
    public void closed() {
    	if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("�ر�con����ʧ�ܣ�");
			}
    }
  
}