package exam25march;
import java.util.Scanner;
import java.sql.*;


public class Employee {

	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","wahidur");
			PreparedStatement ps1=con.prepareStatement("insert into emp values(?,?,?,?,?)");
			PreparedStatement ps2=con.prepareStatement("select * from emp");
			PreparedStatement ps3=con.prepareStatement("select * from emp where emp_id=?");
			PreparedStatement ps4=con.prepareStatement("update emp set city=? where emp_id=?");
			PreparedStatement ps5=con.prepareStatement("delete from emp where emp_id=?");
			Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("Enter Choise:");
				System.out.println("\t1.Add emp details"+           
				                  "\n\t2.View emp details"+"\n\t3.emp details by emp_id"+
						          "\n\t4.Update "+"\n\t5.Delete emp details"+"\n\t6.exit()");
				System.out.println("Enter Choise :");
				switch(Integer.parseInt(sc.nextLine()))
				{
				case 1:
					System.out.println("Enter emp details:");
					System.out.println("Enter  emp id :");
					int  empid=Integer.parseInt(sc.nextLine());
					System.out.println("Enter emp Name :");
					String pN=sc.nextLine();
					System.out.println("Enter emp mail id :");
					String mail=sc.nextLine();
					System.out.println("Enter emp city :");
					String city=sc.nextLine();
					ps1.setInt(1, empid);
					ps1.setString(2, pN);
					ps1.setString(3, mail);
					ps1.setString(4, city);
					System.out.println("enter emp dept id");
					int id=Integer.parseInt(sc.nextLine());
					ps1.setInt(5, id);
					ps1.executeQuery();
					 break;
				case 2:
					System.out.println("**********emp details**********");
					ResultSet rs=ps2.executeQuery();
					while(rs.next())
					{
						System.out.println(String.format("%-20s", rs.getInt(1))+String.format("%-20s", rs.getString(2))+String.format("%-20s", rs.getString(3))+String.format("%-20s", rs.getString(4))+String.format("%-20s", rs.getInt(5)));
					}
					break;
				case 3:
					System.out.println("Enter emp id: ");
					int  code=Integer.parseInt(sc.nextLine());
					ps3.setInt(1, code);
					ResultSet rs2=ps3.executeQuery();
					if(rs2.next())
					{
						System.out.println(String.format("%-20s", rs2.getInt(1))+String.format("%-20s", rs2.getString(2))+String.format("%-20s", rs2.getString(3))+String.format("%-20s", rs2.getString(4))+String.format("%-20s", rs2.getInt(5)));
					}
					else
					{
						System.out.println("Invalid code or not matched code ");
					}
					break;
				case 4:
					
					
					System.out.println("Enter emp id: ");
					int  code2=Integer.parseInt(sc.nextLine());
					System.out.println("Enter modified current city: ");
					String n=sc.nextLine();
					ps4.setString(1, n);
					ps4.setInt(2, code2);
					int k=ps4.executeUpdate();
					if(k>0)
					{
						System.out.println(k+" row updated successfully");
					}
					break;
				case 5:
					System.out.println("Enter code which row want to delete");
					int  code3=Integer.parseInt(sc.nextLine());
					ps5.setInt(1, code3);
					int i=ps5.executeUpdate();
					if(i>0)
					{
						System.out.println(i+" row deleted successfully");
					}
					break;
					
				case 6:
					System.out.println("stope.........");
					System.exit(0);
					
					default:
						System.out.println("Invalid Choise");
				}
			}//end of loop
			
		}catch(Exception  e)
		{
			e.printStackTrace();
		}


	}

}
