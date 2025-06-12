package app.Modelo;

import java.io.InputStream;

public class Usuario {
	 private int id;
	    private String nombreUsuario;
	    private String contrasena;
	    private InputStream  foto;
	    
	    
		public InputStream getFoto() {
			return foto;
		}
		public void setFoto(InputStream foto) {
			this.foto = foto;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombreUsuario() {
			return nombreUsuario;
		}
		public void setNombreUsuario(String nombreUsuario) {
			this.nombreUsuario = nombreUsuario;
		}
		public String getContrasena() {
			return contrasena;
		}
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
	    
	    
}
