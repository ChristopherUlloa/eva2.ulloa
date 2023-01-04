package eva2.ulloa;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Statement;


public class DatabaseTest {
	
	Connection  conn = null;
	final static String HOSTNAME = "localhost";
	final static String PORT = "3306";
	final static String BD_NAME = "evaluacion";
	final static String  USER = "root";
	final static String PASS = "";
	final static String CONNECTION_STRING = "jdbc:mysql://%s:%s/%s";
	
	@Before
	public void before() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(  
				String.format(CONNECTION_STRING, HOSTNAME,PORT,BD_NAME),USER,PASS);  
	}

	
	@After
	public void after() throws SQLException {
		conn.close();
	}
	
	@Test
	public void realizarConeccionBD() throws SQLException {
		assertEquals(true, conn.isValid(10));
		Statement stmt= (Statement) conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT version()");  		
		while(rs.next()){  
			System.out.println(rs.getString(1));  
		}  
	}
}
