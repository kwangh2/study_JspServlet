package testtbl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.driver.parser.Parseable;

public class testTblDAO {
	PreparedStatement ps;
	ResultSet rs;
	Connection conn;

	public boolean isConnect() {
		String user = "hanul";
		String password = "0000";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				if(!conn.isClosed())return true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<testTblDTO> list() {
		
		ArrayList<testTblDTO> list = new ArrayList<>();
		if(isConnect() == false) return list; 
		try {
			ps = conn.prepareStatement("select * from TESTTBL ");
			rs = ps.executeQuery();
			while(rs.next()) {
				testTblDTO dto = new testTblDTO();
				dto.setUsername(rs.getString("username"));
				dto.setBirthday(Integer.parseInt(rs.getString("birthday")));
				dto.setBloodtype(rs.getString("bloodtype"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
