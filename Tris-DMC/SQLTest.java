//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.SQLException;
import java.sql.*;

public class SQLTest {

	public static void main(String[] args) {
		
		      String url = "jdbc:mysql://localhost:3306/TRIS";
		      
			  String username = "root";
		      
			  String password = "root";
		      
		      Connection conn = null;
		      Statement stat;
		      ResultSet result;
		      
		      try {

		        Class.forName("com.mysql.jdbc.Driver");
		        } catch (Exception ex) {
		            System.out.println("Error in loading driver");
		        }
		     
		      
		      try { 
		        
		        conn = DriverManager.getConnection(url, username, password) ;
		      
		        if (conn != null)
		            System.out.println("Database connected!");
		        
		        
		      } catch (SQLException e) {
		        
		          throw new IllegalStateException("Cannot connect the database!", e);
		      }
		      
		      try {
		    	  
		    	  stat = conn.createStatement();
		    	  
		      }   catch (SQLException e) {
		        
		          throw new IllegalStateException("Cannot create Statement!", e);
		      }
		      
		      try {
		      
		    	  result = stat.executeQuery("SELECT * FROM ESPERIENZA");
		    	 
		      
		    	  while (result.next()) {
		    	  
		    		  System.out.println("ID:"+result.getString(0)+" MOSSE:"+ result.getString(1)+ " ESITO:"+ result.getString(2));
		    	  
		    	  }
		    	  
		      }   catch (SQLException e) {
			        
		          throw new IllegalStateException("Cannot execute query", e);
		      }  
		    		  
		        
		   } //end main

		} //end

