package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections 
{
	public static void main (String args[]) throws SQLException
	{
		
		String url="jdbc:mysql://localhost:3306/dharunya";
		String username="root";
		String password="W@0609dharun@";
		
		
		try {
			
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=null;
					Statement stmt=null;
					PreparedStatement p=null;
			
			
				    conn=DriverManager.getConnection(url,username,password);
					stmt=conn.createStatement();
					
					
					p=conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)");
					p.setInt(1, 3);
					p.setString(2, "Harini");
					p.setString(3, "T");
					p.setInt(4, 19000);
					p.setString(5,"Coimbatore");
					p.setString(6, "harini@gmail.com");
					
					System.out.println("Records inserted");
					
					
					

					
					String query="SELECT * FROM employee";
					
					ResultSet res=stmt.executeQuery(query);
					
					while(res.next())
					{
						System.out.println("The result set are");
						String fname=res.getString("first_name");
						
						int salary=res.getInt("salary");
						System.out.println("The name is "+fname);
						
						System.out.println("The salary is "+salary);
						
						System.out.println();
					}
					
					
					
					//task -> to pass arguements in the query using preparedStatement
					
					String query2="SELECT * FROM employee where salary >?";
					
					p = conn.prepareStatement(query2);

		           
		            p.setInt(1, 1000);
					
					ResultSet r2=p.executeQuery();
					
					while(r2.next())
					{
						System.out.println("The result set applied by conditions are ");
						String fname=r2.getString("first_name");
						System.out.println("The name is "+fname);
					}
					
					
					
					
					
				
							
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		 
	}

}
