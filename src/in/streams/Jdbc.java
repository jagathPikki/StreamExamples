package in.streams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {

	public static void main(String[] args) {

		String user ="root";
		String pwd ="Jagath@143";
		String url ="jdbc:mysql://localhost:3306/employees";
		String c ="com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(c);
			
			Connection connection = DriverManager.getConnection(url,user,pwd);

			if(connection!=null) {
				System.out.println("connection established succesFully !");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
