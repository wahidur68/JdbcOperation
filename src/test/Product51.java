package test;

import java.sql.*;

public class Product51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","wahidur");
			Statement stm=con.createStatement();
			System.out.println("connection created......");
			ResultSet rs=stm.executeQuery("select * from Product51");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getInt(4));

			}
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
