

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class UpdateData 
{
	public static void main(String[] args)
	{		
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		
		try
		{
			//1. Load the Driver
			
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			//2. get the db connection via dburl
			String dburl="jdbc:mysql://localhost:3306/students_1234?user=root&password=root";
			connection = DriverManager.getConnection(dburl);
			
			//3.Issue the sql query via connection
			String query = "update students_details "
					+ "set lastname='Engineering' where regno=3";
			statement = connection.createStatement();
			int count = statement.executeUpdate(query);
			
			if(count==1) 
			{
				System.out.println("1 row updated");
			}
			else 
			{
				System.out.println("no row updated");
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			//5 close all jdbc object
				try
				{  
					if(connection!=null)
					{
						connection.close();
					}
					if(preparedStatement!=null)
					{
						preparedStatement.close();
					}
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}

		}	
		

	}
}