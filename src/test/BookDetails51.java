package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookDetails51 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "wahidur");

			Statement stm = con.createStatement();

			while (true) {
				System.out.println("***Enter Choise***");
				System.out.println("\t\t1.Add Book Deatais" + "\n\t\t2.View Book Details" + "\n\t\t3.exit");
				System.out.println("Enter choise : ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					System.out.println("Add Your Book Details :");
					System.out.println("Enter book code :");
					String bCode = sc.nextLine();
					System.out.println("Enter book name :");
					String bName = sc.nextLine();
					System.out.println("Enter book aouther name :");
					String bA = sc.nextLine();
					System.out.println("Enter book price");
					float bPrice = Float.parseFloat(sc.nextLine());
					System.out.println("Enter book qty");
					int bQ = Integer.parseInt(sc.nextLine());
					try {
						
					
					int k = stm.executeUpdate("insert into BookDetails51 values('" + bCode + "','" + bName + "','" + bA
							+ "'," + bPrice + "," + bQ + ")");
					
					if (k > 0) {
						System.out.println(k + " row insetred successfully....");
					}

					break;
					}catch(Exception e) {
						System.err.println("Dont Enter duplicate value");
					}
				case 2:
					ResultSet rs = stm.executeQuery("select * from BookDetails51");
					while (rs.next()) {
						System.out.println(String.format("%-20s",rs.getString(1)) + String.format("%-20s",rs.getString(2))
								+ String.format("%-20s",rs.getString(3)) + String.format("%-20s",rs.getFloat(4)) + String.format("%-20s",rs.getInt(5)));
					}

					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("Invalid choise");
				}// end of switch

			} // end of loop

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
