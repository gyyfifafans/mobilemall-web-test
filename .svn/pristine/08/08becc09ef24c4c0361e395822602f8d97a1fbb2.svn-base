package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
//cant handle it 20170719
public class DBUtil {
	public static final String url = "jdbc:mysql://172.16.130.3:3306/shop";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "pdc_rd";
	public static final String password = "cfds0920";
	
	public Connection conn = null;
	public PreparedStatement pst = null;
	
	public DBUtil(String sql){
		try{
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);
			pst = conn.prepareStatement(sql);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public DBUtil(String sql,String baseurl){
		try{
			Class.forName(name);
			conn = DriverManager.getConnection(baseurl, user, password);
		    pst = conn.prepareStatement(sql);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void close(){
		try{
			this.conn.close();
			this.pst.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
