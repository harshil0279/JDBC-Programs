

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyFirstJDBCProgram 
{

	public static void main(String[] args) throws ClassNotFoundException 
	{
		Connection connection = null;
		Statement statement = null;
	
		ResultSet resultset = null;

		try
		{				
			//1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			//2. get the DB connection via driver
			String dburl = "jdbc:mysql://localhost:3306/students_1234?user=root&password=root";
			connection = DriverManager.getConnection(dburl);

			//3.Issue"SQL queries" via "connection"

			String query = "select * from students_details";
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);

			//4."Process the results returned by sql queries

			while(resultset.next())
			{
				int regNum = resultset.getInt("regno");

				String fNM = resultset.getString("firstname");

				String mNM = resultset.getString("middlename");

				String lNM = resultset.getString("lastname");

				System.out.println("RegNo:"+regNum);

				System.out.println("First Name:"+fNM);

				System.out.println("Middle Name:"+mNM);

				System.out.println("Last Name:"+lNM);

				System.out.println("________________");
			}//End of while
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//5.close All the "JDBC object"
			try 
			{
				if(connection != null)
				{
					connection.close();
				}
				if(statement != null)
				{
					statement.close();
				}
				if(resultset != null)
				{
					resultset.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}//End of outer try-catch


	}//End of main

}//end of class
