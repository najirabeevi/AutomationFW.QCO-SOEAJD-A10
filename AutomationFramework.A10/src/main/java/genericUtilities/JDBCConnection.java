package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JDBCConnection {
	
@Test

public void executeProgram() throws SQLException
{
	//fetch driver from database
		Driver dref=new Driver();
	//register the driver/database
		DriverManager.registerDriver(dref);
	
		//Get Connect with Driver - give database name
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
				
				//Issue create statement
				Statement state = con.createStatement();
				
				//Execute the query - table name 
				ResultSet result = state.executeQuery("select * from customerinfo;");
				
				while(result.next())
				{
					System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
				}
				
				//Close the database
				con.close();
	
}

@Test

public void executeUpdateSample() throws SQLException
{
   //fetch driver from database
	Driver dref=new Driver();
	
	//Register the driver
	DriverManager.registerDriver(dref);
	
	//Get connect with Driver - give database name
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
	
	//Issue create statement
	
	Statement state = con.createStatement();
	
	//Execute the query-table name
	int result = state.executeUpdate("insert into customerinfo values('kareena',12,'Chennai')");
	if(result==1)
	{
		System.out.println("data added");
	}
	else
	{
		System.out.println("data not added");
	}
	
	//close the database
	con.close();
	
	
}
}
