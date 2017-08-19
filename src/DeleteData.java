

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DeleteData 
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
			String query = "delete from students_details where regno=2";
			statement = connection.createStatement();
			int count = statement.executeUpdate(query);
			
			if(count==1) 
			{
				System.out.println("1 row deleted");
			}
			else 
			{
				System.out.println("no row deleted");
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
					if(statement!=null)
					{
						statement.close();
					}
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}

		}	
		

	}
}