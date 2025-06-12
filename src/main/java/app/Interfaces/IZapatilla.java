package app.Interfaces;

import java.util.List;

import app.Modelo.Zapatilla;

public interface IZapatilla {
	// Métodos CRUD
		public void registrar(Zapatilla Zapatilla);			// Create
		Zapatilla buscarPorID(int id);			// Read
		boolean actualizar(Zapatilla Zapatilla);	// Update
		boolean eliminar(int id);			// Delete
		
		// Métodos adicionales
		List<Zapatilla> buscarPorMarca(int marca_ID);
}
