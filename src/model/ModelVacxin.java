package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Vacxin;

public class ModelVacxin {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	ModelConnectdb mConnect = new ModelConnectdb();
	public int checkItem(String name){
		int result = 0;
		String sql = "SELECT * FROM vacxin WHERE TenVacxin = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()){
				result = 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;	
	}
	public Vacxin getItem(String name){
		Vacxin vx = null;
		String sql = "SELECT * From vacxin WHERE TenVacxin = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			if(rs.next()){
				String tenvacxin = rs.getString("TenVacxin");
				int somui = rs.getInt("SoMui");
				vx = new Vacxin(tenvacxin, somui);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vx;
	}
}
