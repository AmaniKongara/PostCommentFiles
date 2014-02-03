import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TopicExtract {
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException{
		
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://localhost:3306/wiki";
	    Connection connection = null;
	    connection = DriverManager.getConnection(connectionURL, "root", "amanis");
	    Statement statement1 = null;
	    statement1 = connection.createStatement();
	    Statement statement2 = null;
	    statement2 = connection.createStatement();
	    ResultSet rs1 = null;
	    ResultSet rs2 = null;
	    String cmd1=" Select concept from relation where level<=5";
	    String cmd2=" Select concept from relation_maths where level<=3";
	    
	    String file = "E:\\december\\techtopics.txt";	   
	    	
			rs1 =statement1.executeQuery(cmd1);
			rs2 =statement2.executeQuery(cmd2);
		    
			File outputfile = new File(file);
		    if (!outputfile.exists()) {
				outputfile.createNewFile();
			}
			FileOutputStream fis = new FileOutputStream(outputfile);  
		    PrintStream out = new PrintStream(fis);  
		    System.setOut(out);
		    
		    while(rs1.next()){
				System.out.println(rs1.getString(1));
		    }

			while(rs2.next()){
				System.out.println(rs2.getString(1));
			}
			fis.close();  
	}
}
