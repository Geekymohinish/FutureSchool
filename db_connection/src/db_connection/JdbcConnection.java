package db_connection;

import java.sql.*;

public class JdbcConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/nightly_run";
		String user = "root";
		String pwd = "rootroot";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String query = "select * from component";
		Connection con = DriverManager.getConnection(url, user, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
	
		while(rs.next()) {
			System.out.print(rs.getString("sno")+' ');
			System.out.println(rs.getString("compname"));
		}
		
		query = "insert into component values(3,'fpd')";
		st.executeUpdate(query);
		
		query = "select * from component";
		rs = st.executeQuery(query);
	
		while(rs.next()) {
			System.out.print(rs.getString("sno")+' ');
			System.out.println(rs.getString("compname"));
		}
		
		st.close();
		con.close();
	}
}
