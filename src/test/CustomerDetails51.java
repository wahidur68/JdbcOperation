package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerDetails51 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","wahidur");
			Statement stm=con.createStatement();
			Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("***Enter Your Choise****");
				System.out.println("\t\t1.Add Customer Deatails:"+"\n\t\t2.Viewe Customer Deatails:"+"\n\t\t3.exit");
				System.out.println("Enter choise :");
				switch(Integer.parseInt(sc.nextLine()))
				{
					case 1:
						System.out.println("Enter Customer Details");
						System.out.println("Enter Cusomter Id :");
						String cId=sc.nextLine();
						System.out.println("Enter Cusomter Name :");
						String cName=sc.nextLine();
						System.out.println("Enter Cusomter Email Id :");
						String cEmail=sc.nextLine();
						System.out.println("Enter Cusomter Ph.No :");
						long ph=Long.parseLong(sc.nextLine());
						System.out.println("Enter Cusomter City :");
						String city=sc.nextLine();
						int k=stm.executeUpdate("insert into CustomerDetails51 values('"+cId+"','"+cName+"','"+cEmail+"',"+ph+",'"+city+"')");
						if(k>0)
						{
							System.out.println(k+" row inseted successfully");
						}
						break;
					case 2:
						ResultSet rs=stm.executeQuery("select * from CustomerDetails51");
						while(rs.next())
						{
							System.out.println(String.format("%-15s", rs.getString(1))+String.format("%-20s", rs.getString(2))+String.format("%-20s",rs.getString(3))+String.format("%-20s", rs.getLong(4))+""+String.format("%-20s", rs.getString(5)));
						
						}
						break;
					case 3:
						System.exit(0);
					default:
						System.out.println("INVALID USER CHOICE");
					
				}
				
			}
						
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
