

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;



public class InsertData
{
	public static void main(String[] args) 
	{

		int regno  = Integer.parseInt(args[0]);
		String firstname = (args[1]);
		String middlename = (args[2]);
		String lastname = (args[3]);
        
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try 
		{

			//1 Load the driver
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			//2. get the db connection via dburl
			String dburl="jdbc:mysql://localhost:3306/students_1234?user=root&password=root";
			connection = DriverManager.getConnection(dburl);

			//3.Issue the sql query via connection
			String query = "insert into students_details values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			//4 Process the result
			preparedStatement.setInt(1,regno);
			preparedStatement.setString(2,firstname);
			preparedStatement.setString(3,middlename);
			preparedStatement.setString(4,lastname);

			preparedStatement.executeUpdate();

			System.out.println("data updated");
		} 
		catch (SQLException e) 

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