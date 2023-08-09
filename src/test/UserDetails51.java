package test;
import java.util.Scanner;
import java.sql.*;
public class UserDetails51 {

	public static void main(String[] args) {
		try {
		     Class.forName("oracle.jdbc.driver.OracleDriver");
		    
		     Connection con  =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","wahidur");
		     PreparedStatement ps1=con.prepareStatement("insert into UserDetails51 values(?,?,?,?,?,?,?)");
		        PreparedStatement ps2=con.prepareStatement("select * from UserDetails51");
				PreparedStatement ps3=con.prepareStatement("select * from UserDetails51 where uname=?");
				PreparedStatement ps4=con.prepareStatement("update UserDetails51 set ++=? where uname=?");
				PreparedStatement ps5=con.prepareStatement("delete from UserDetails51 where uname=?");
		     Scanner sc=new Scanner(System.in);
		     while(true)
		     {
		    	 System.out.println("***Enter Your Choise****");
		    	 System.out.println("\t1.Add UserDetails"+           
		                  "\n\t2.ViewUserDetails"+"\n\t3.View UserDetails by username"+
				          "\n\t4.Update by code"+"\n\t5.Delete productUserDetai by UserName"+"\n\t6.exit()");
		System.out.println("Enter Choise :");
				 switch(Integer.parseInt(sc.nextLine()))
				 {
				 case 1:
					 System.out.println("Enter user Details : ");
					 
					 System.out.println("Enter user name : ");
					 String uname=sc.nextLine();
					 System.out.println("Enter user password : ");
					 String upwd=sc.nextLine();
					 System.out.println("Enter user first name : ");
					 String uf=sc.nextLine();
					 System.out.println("Enter user last name : ");
					 String ul=sc.nextLine();
					 System.out.println("Enter user city : ");
					 String city=sc.nextLine();
					 System.out.println("Enter user nail id : ");
					 String mail=sc.nextLine();
					 System.out.println("Enter user ph.No : ");
					 long ph=Long.parseLong(sc.nextLine());
					
					 
					 //int k=stm.executeUpdate("insert into UserDetails51 values('"+uname+"','"+upwd+"','"+uf+"','"+ul+"','"+city+"','"+mail+"',"+ph+")");
					 ps1.setString(1,uname );
					 ps1.setString(2, upwd);
					 ps1.setString(3,uf );
					 ps1.setString(4, ul);
					 ps1.setString(5, city);
					 ps1.setString(6, mail);
					 ps1.setLong(7, ph);
					 ps1.executeQuery();
					 break;
					 
				 case 2:
					 System.out.println("\t\t**********Users details**********");
						ResultSet rs=ps2.executeQuery();
						while(rs.next())
						{
							System.out.println(String.format("%-20s", rs.getString(1))+String.format("%-20s", rs.getString(2))
							+String.format("%-20s", rs.getString(3))+String.format("%-20s", rs.getString(4))
							+String.format("%-20s", rs.getString(5))+String.format("%-20s", rs.getString(6))+String.format("%-20s", rs.getLong(7)));
							
						}
					 break;
					 
				 case 3: 
					 System.out.println("Enter UserName: ");
						String name=sc.nextLine();
						ps3.setString(1, name);
						ResultSet rs2=ps3.executeQuery();
						if(rs2.next())
						{
							System.out.println(String.format("%-20s", rs2.getString(1))+String.format("%-20s", rs2.getString(2))
							+String.format("%-20s", rs2.getString(3))+String.format("%-20s", rs2.getString(4))
							+String.format("%-20s", rs2.getString(5))+String.format("%-20s", rs2.getString(6))+String.format("%-20s", rs2.getLong(7)));
							
						}
						else
						{
							System.out.println("Invalid code or does not  matched username ");
						}
					 break;
					 
				 case 4:
					    System.out.println("Enter username: ");
						String uname1=sc.nextLine();
						System.out.println("Enter modified data that means phno : ");
						long n=Long.parseLong(sc.nextLine());
						ps4.setLong(1, n);
						ps4.setString(2, uname1);
						int k=ps4.executeUpdate();
						if(k>0)
						{
							System.out.println(k+" row updated successfully");
						}
						else
						{
							System.err.println("invalid username");
						}
					 break;
					 
				 case 5:
					 System.out.println("Enter user name which row want to delete");
						String str=sc.nextLine();
						ps5.setString(1, str);
						int i=ps5.executeUpdate();
						if(i>0)
						{
							System.out.println("deleted successfully");
						}
						else
						{
							System.err.println("not matched user name !!! sorry operation failed");
						}
					 break;
				 case 6:
					 System.exit(0);
					 default:
						 System.out.println("Invalid option");
				 }
		     }
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
