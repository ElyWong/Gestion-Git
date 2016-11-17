package listas;

public class Usuarios {
	String nombre, tipo, email, pass;
	int id;
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public int getId() {
		return id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setId(int id) {
		this.id = id;
	}
}
