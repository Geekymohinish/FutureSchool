package db_connection;

import java.sql.*;

public class JdbcConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/nightly_run";
		String user = "root";
		String pwd = "rootroot";
	
		String query = "select * from component";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
	
		while(rs.next()) {
			System.out.print(rs.getString("sno")+' ');
			System.out.println(rs.getString("compname"));
		}
		st.close();
		con.close();
	}
}
