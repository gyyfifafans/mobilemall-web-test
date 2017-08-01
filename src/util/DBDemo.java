package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDemo {
	
	static String sql = null;
	static DBUtil db = null;
	static ResultSet ret = null;
	
	public static void main(String[]args){
		sql = "SELECT * FROM orders WHERE orderSn='D17071909373232519'";
		db = new DBUtil(sql);
		try{
			ret = db.pst.executeQuery();
			while(ret.next()){
				System.out.println(ret.getString(1));//id
				System.out.println(ret.getString(2));//siteId
				System.out.println(ret.getString(3));//isTest
				System.out.println(ret.getString(4));//hasSync
				
			}
			ret.close();
			db.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
/*
 * String sql = "update goddess set name=?,mobie=?,email=?,address=? where id=?";
 
    PreparedStatement ptmt = conn.prepareStatement(sql);
 
    ptmt.setString(1, goddess.getName());
    ptmt.setString(2, goddess.getMobie());
    ptmt.setString(3, goddess.getEmail());
    ptmt.setString(4, goddess.getAddress());
 * */
