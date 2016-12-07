import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class DatesUpDate {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/rb";
	   
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	   
	/**
	 * @param args
	 */
	 public static void printRs(ResultSet rs) throws SQLException{
	      //Ensure we start with first row
	      rs.beforeFirst();
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("id");
	         Timestamp timestamp = rs.getTimestamp("transactionDate");

	         //Display values
	         System.out.print("ID: " + id);
	         System.out.print(", DATE: " + timestamp.toString());
	     }
	     System.out.println();
	   }//end printRs()
	 
	public static void main(String[] args) {
		 
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT * from transactions";
			ResultSet rs = stmt.executeQuery(sql);
			
			System.out.println("List result set for reference....");
		    printRs(rs);
		    rs.beforeFirst();
	      while(rs.next()){
	         //Retrieve by column name
	         /*int id  = rs.getInt("id") + 1;
	         rs.updateDouble("id", id);
             rs.updateRow();*/
	    	  Timestamp ts = rs.getTimestamp("transactionDate");
	          Calendar cal = Calendar.getInstance();
	    	  cal.setTime(new Date(ts.getTime()));
	    	  int year = cal.get(Calendar.YEAR);
	    	  int month = cal.get(Calendar.MONTH);
	    	  int day = cal.get(Calendar.DAY_OF_MONTH);
	    	  month = month+1;
	    	  if(month>11){
	    		  month = 0; 
	    		  year = year + 1;
	    	  }
	    	  cal.set(Calendar.DAY_OF_MONTH, day);// I might have the wrong Calendar constant...
	    	  cal.set(Calendar.MONTH, month);// -1 as month is zero-based
	    	  cal.set(Calendar.YEAR, year);
	    	  Timestamp tstamp = new Timestamp(cal.getTimeInMillis());
	    	  rs.updateTimestamp("transactionDate", tstamp);
	          rs.updateRow();
	      }
	      System.out.println("List result set showing new ages...");
	      printRs(rs);
	      rs.close();

		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt != null) 
					stmt.close();
                if(conn != null) 
                	conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}

	}

}
