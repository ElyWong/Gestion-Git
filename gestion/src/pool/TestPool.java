package pool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import listas.Usuarios;



/**
 * Servlet implementation class TestPool
 */
@WebServlet("/TestPool")
public class TestPool extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	private int lastColums;
       
   
    public TestPool() {
        super(); 
        // TODO Auto-generated constructor stub
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
	

	public int getLastcolums(){
		int n=lastColums;
		lastColums=0;
		return n;
	}

	public List<Usuarios> listaUsuarios(String tipoUsuario) throws SQLException {
		List <Usuarios> lstUsuarios=null;
		this.getconexion();
		
		String query="select * from usuario where tipo='"+tipoUsuario+"' order by nombre";
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		if (rs.first()) {
			lstUsuarios = new ArrayList<>();

			do {
				Usuarios u = new Usuarios();
				u.setId(rs.getInt("idusuario"));
				u.setNombre(rs.getString("nombre"));
				u.setTipo(rs.getString("tipo"));
				u.setPass(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				
				lstUsuarios.add(u);
			} while (rs.next());
		}
		
		return lstUsuarios;
		
	}
	
	public boolean eliminarUsuario(String idAnalista) {
		boolean respuesta = false;
		
		try {
			this.getconexion();
		
			String query = "delete from usuario where idusuario="+idAnalista;
		
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			
			respuesta = true;
		} catch(SQLException e) {
			System.err.println("Error al eliminar analista!!!!");
			e.printStackTrace();
		}
		return respuesta;
	}
	
	public boolean agregarUsuario(String idUsuario, String nombre, String tipo, String password) {
		boolean respuesta = false;
		
		try {
			this.getconexion();
			
			String query = "insert into usuario (idusuario, nombre, ap, am, tipo, password) values ('"
					+ idUsuario + "','"+nombre+"','"+tipo+"','"+password+"')";
			System.out.println("query:"+query);
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			
			respuesta = true;
		} catch(SQLException e) {
			System.err.println("Error al insertar analista!!!");
			e.printStackTrace();
		}
		
		return respuesta;
	}
	
	public List<Usuarios> recuperaUsuario (String id) {
		List <Usuarios> infoUsuario = null;
		
		try {
			this.getconexion();
			
			String query = "select * from usuario where idusuario='"+id+"'";
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			if (rs.first()) {
				infoUsuario = new ArrayList<>();

				do {
					Usuarios u = new Usuarios();
					u.setId(rs.getInt("idusuario"));
					u.setNombre(rs.getString("nombre"));
					u.setTipo(rs.getString("tipo"));
					u.setPass(rs.getString("password"));
					u.setEmail(rs.getString("email"));
					
					infoUsuario.add(u);
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.err.println("Error al recuperar analista!!!");
			e.printStackTrace();
		}
		
		return infoUsuario;
	}
	
	public boolean editarUsuario (String id, String nombre) {
		boolean respuesta = false;
		
		try {
			this.getconexion();
			
			String query = "update usuario set nombre = '" + nombre + "', where idusuario='" + id + "'";
			System.out.println("query:"+query);
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			
			respuesta = true;
		} catch(SQLException e) {
			System.err.println("Error al insertar analista!!!");
			e.printStackTrace();
		}
		
		return respuesta;		
	}
	
	
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
