package usertbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import oracle.jdbc.driver.OracleDriver;

public class UserTblDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean isConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hanul";
		String password = "0000";
		try {
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				if(!conn.isClosed()) return true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//전체목록조회
	public ArrayList<UserTblDTO> selectList() {
		ArrayList<UserTblDTO> list = new ArrayList<>();
		
		if(!isConnection()) return list;
		try {
			ps = conn.prepareStatement("select * from usertbl");
			rs = ps.executeQuery();
			while(rs.next()) {
				UserTblDTO dto = new UserTblDTO();
				dto.setUsername(rs.getString("username"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setBirthyear(rs.getInt("BIRTHYEAR"));
				dto.setMobile(rs.getString("Mobile"));
				list.add(dto);
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//데이터 1건 조회
	public UserTblDTO selectOne(String name) {
		UserTblDTO dto = new UserTblDTO();
		ArrayList<UserTblDTO> list = new ArrayList<>();
		if(!isConnection()) return dto;
		try {
			ps = conn.prepareStatement("select * from usertbl where username=?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new UserTblDTO();
				dto.setUsername(rs.getString("username"));
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setBirthyear(rs.getInt("BIRTHYEAR"));
				dto.setMobile(rs.getString("Mobile"));
				list.add(dto);
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
		
	}
	
	public void updateTbl(String name) {
		UserTblDTO dto = new UserTblDTO();
		ArrayList<UserTblDTO> list = new ArrayList<>();
		
		if(!isConnection()) return;
		 
		try {
			ps = conn.prepareStatement("update usertbl set birthyear=?, address=?, mobile=? where  username = ?;");
			ps.setInt(1, Integer.parseInt("mobile"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

} 
