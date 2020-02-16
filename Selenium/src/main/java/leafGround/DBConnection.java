package leafGround;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	     System.out.println("Driver Loaded");
	   
	   
	 
	    // Specify the path of the database
	 
	      String dblocation= "C:\\Users\\Desktop\\DB\\FacebookDB1.accdb";
	 
	             
	    // This will connect with Database , getConnection taking three argument
	    //  first argument Test_Oracle is the dsn which you can change as per your system,
	 
	 
	       Connection con=DriverManager.getConnection("jdbc:odbc:AscentAccess;DBQ="+dblocation);            
	 
	       System.out.println("Connection created");
	 
	   // This will create statement  
	        Statement smt=con.createStatement();
	          
	        System.out.println("Statement created");
	 
	   // Now execute the query, here facebook is the table which I have created in DB 
	    
	        ResultSet rs=  smt.executeQuery("Select * from Facebook");
	 
	        System.out.println("Query Executed");
	 
	  // Iterate the resultset now
	      
	       while(rs.next()){
	       String uname=    rs.getString("username");
	       String pass=        rs.getString("password");
	       String email=      rs.getString("email");
	 
	        System.out.println("Uname is "+uname+" password is "+pass+" email id is "+email);
	   
	  }
	}
	    

}
