package app.Interfaces;

import javax.servlet.http.HttpServletResponse;

import app.Modelo.Usuario;


public interface Ilogin {
	Usuario validar(String nombreUsuario, String contrasena);
	public void insertar (Usuario u);
	public void listarImg(int id, HttpServletResponse response);
}
