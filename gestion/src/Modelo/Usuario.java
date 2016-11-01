package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import pool.TestPool;

public class Usuario {
	String usu, pass, correo, newPass;
	TestPool tp;
	public Usuario(String usuario, String password) {
		usu=usuario;
		pass=password;
		tp= new TestPool();
	}
	public Usuario(String usuario, String email, String password, String nuevaPassword) {
		usu=usuario;
		correo=email;
		pass=password;
		newPass=nuevaPassword;
		tp= new TestPool();
	}
	public boolean verificarPassword(){
		ArrayList<String> s=new ArrayList<String>();
		try {
			s=tp.ejecutar("select password from usuario where idUsuario="+usu+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s.get(0).equals(pass))
			return true;
		else
			return false;
	}
	
	public boolean verificarCorreo(){
		ArrayList<String> s=new ArrayList<String>();
		try {
			s=tp.ejecutar("select email from usuario where idUsuario="+usu+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(s.get(0));
		if(s.get(0)!=null && !s.get(0).equals(""))
			return true;
		else{
			
			return false;
		}
			
	}
	public boolean verificarExistencia(){
		ArrayList<String> s=new ArrayList<String>();
		try {
			s=tp.ejecutar("select * from usuario where idUsuario="+usu+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s.size()!=0)
			return true;
		else{
			
			return false;
		}
			
	}
	public int verificarTipoUsuario(){
		ArrayList<String> s=new ArrayList<String>();
		try {
			s=tp.ejecutar("select tipo from usuario where idUsuario="+usu+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!s.isEmpty()){
			String aux=s.get(0);
			if(aux.equals("alumno")){
				return 0;
			}
			else if(aux.equals("jefe de area")){
				return 1;
			}
			else if(aux.equals("analista")){
				return 2;
			}
			else if(aux.equals("jefe de gestion")){
				return 3;
			}
			else if(aux.equals("subdirector")){
				return 4;
			}
		}
		return -1;	
	}
	public int registrarCorreo(){
		String q="update usuario set ";
		int r=0;
		q+="email ='"+correo+"'";
		q+=" where idUsuario="+usu+";";
		//System.out.println(q);
		try {
			r= tp.ejecutarSR(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public int registrarContra(){
		String q="update usuario set ";
		int r=0;
		q+="password ='"+newPass+"'";
		q+=" where idUsuario="+usu+";";
		System.out.println(q);
		try {
			r= tp.ejecutarSR(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

}
