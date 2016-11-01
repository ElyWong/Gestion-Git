package pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class TestPool
 */
@WebServlet("/TestPool")
public class TestPool extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	private int lastColums;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestPool() {
        super(); 
        // TODO Auto-generated constructor stub
    }
    
    public ArrayList<String> ejecutar(String consulta) throws SQLException {
		ResultSet rs = null;
        Statement stmt = null;
        int n=0;
        ArrayList<String> resultados=new ArrayList<String>();
        try {
        	
			stmt = getconexion().createStatement();
	        rs = stmt.executeQuery(consulta);
	        ResultSetMetaData r=rs.getMetaData();
	        n=r.getColumnCount();
	        lastColums=n;
	        while(rs.next()){
	            for(int i=1;i<=n;i++){
	                resultados.add(rs.getString(i));
	                //System.out.println(rs.getString(i))
	            }
	        }
	        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        conn.close();
        return resultados;
	}
    
    public ResultSet ejecutarQuery(String sql) throws SQLException {
		ResultSet rs = null;
        Statement stmt = null;
        try {
        	
			stmt = getconexion().createStatement();
	        rs = stmt.executeQuery(sql); 
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return rs;
	}
    
    
	public int ejecutarSR(String consulta) throws SQLException{
        int tuplas=0;
        try{
                Statement stmt=getconexion().createStatement();
                tuplas=stmt.executeUpdate(consulta);
        }catch(SQLException sqle){
                sqle.printStackTrace();
        }
        if(tuplas==1){
                System.out.println("Insercion exitosa");
        }
        else{
                System.out.println("Fallo la insercion");
        }
        conn.close();
        return tuplas;
	}
	public Connection getconexion() throws SQLException{
		Context initContext;
		DataSource ds;
		Context envContext;
		try {
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("pool1Jdbc/mysqlTest");
			conn=ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("CORRECTO!!!!!!!!!!!!!!!!!");
		return conn;
	}

	public int getLastcolums(){
		int n=lastColums;
		lastColums=0;
		return n;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
