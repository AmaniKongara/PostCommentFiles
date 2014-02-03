import java.util.HashSet;
import java.util.Set;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.*;

public class FileExtract {
public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException{
	Set<Integer> set = new HashSet<Integer>();
	Class.forName("com.mysql.jdbc.Driver");
	String connectionURL = "jdbc:mysql://localhost:3306/wiki";
    Connection connection = null;
    connection = DriverManager.getConnection(connectionURL, "root", "amanis");
    Statement statement1 = null;
    statement1 = connection.createStatement();
    Statement statement2 = null;
    statement2 = connection.createStatement();
    Statement statement3 = null;
    statement3 = connection.createStatement();
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    ResultSet rs3 = null;
    String cmd1=" SELECT Title,Body FROM wiki.so_posts where Topic='042011 Theoretical Computer Science' and Id='";
    String cmd2=" SELECT Body FROM wiki.so_posts where Topic='042011 Theoretical Computer Science' and ParentId='";
    String cmd3=" SELECT text FROM wiki.so_comments where Topic='042011 Theoretical Computer Science' and postid='";
    
    String file = "E:\\december\\pcfiles\\";
    
    
    
      for(int i=1; i<=5793;i++){
    	
    	String f;  
    	String total1 = cmd1 + i + "';";
    	String total2 = cmd2 + i + "';";
    	String total3 = cmd3 + i + "'and score > '1';";
    	
		rs1 =statement1.executeQuery(total1);
		rs2 =statement2.executeQuery(total2);
		rs3 =statement3.executeQuery(total3);
	    
	    
	    if(rs1.next()){
	    	f = file + i + ".html";
	    	File outputfile = new File(f);
		    if (!outputfile.exists()) {
				outputfile.createNewFile();
			}
		    FileOutputStream fis = new FileOutputStream(outputfile);  
		    PrintStream out = new PrintStream(fis);  
		    System.setOut(out);
		   
		    System.out.println("ParentPost:");
			System.out.println(rs1.getString(1));
			System.out.println(rs1.getString(2));
		while(rs1.next()){
			System.out.println(rs1.getString(1));
			System.out.println(rs1.getString(2));
		}
		while(rs2.next()){
			System.out.println("ChildPosts:");
			System.out.println(rs2.getString(1));
		}
		while(rs3.next()){
			System.out.println("Comments:");
			System.out.println(rs3.getString(1));
		}
		fis.close();
	    }
	    
    }
}
}

