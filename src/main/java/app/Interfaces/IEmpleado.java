package app.Interfaces;


import java.util.List;

import app.Modelo.Empleado;

public interface IEmpleado {
	public void registrar(Empleado e); // Retorna ID
	Empleado buscarPorID(int id);
	public void actualizar(Empleado e);
	public void eliminar(Empleado e);
	List<Empleado> listar(); 
}
