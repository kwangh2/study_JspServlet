package usertbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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
				dto.setAddress(rs.getString("address"));
				dto.setBirthyear(rs.getInt("birthyear"));
				dto.setMobile(rs.getString("mobile"));
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
	
	//데이터 1건 업데이트
	//1. Conn 통신 열기 ->isConnection();
	//2. Statement 통신을 통해 전송  -> conn 객체, sql
	//3.Select의 경우 결과를 받기 ResultSet
	public void update(UserTblDTO dto) {
		 if(isConnection()==false) return;
		 try {
			ps = conn.prepareStatement("update usertbl set address = ?, birthyear = ?, mobile = ? where username = ? ");
			ps.setString(1, dto.getAddress());
			ps.setInt(2, dto.getBirthyear());
			ps.setString(3, dto.getMobile());
			ps.setString(4, dto.getUsername());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String username) {
		 if(isConnection()==false) return;
		 try {
			ps = conn.prepareStatement("delete from usertbl where username = ? ");
			ps.setString(1, username);
			
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert(UserTblDTO dto) {
		if(isConnection()==false) return ;
		
		try {
			ps = conn.prepareStatement("insert into usertbl (USERNAME, BIRTHYEAR, ADDRESS, MOBILE)  values (?,?,?,?) ");
			ps.setString(1, dto.getUsername());
			ps.setInt(2, dto.getBirthyear());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getMobile());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
} 
