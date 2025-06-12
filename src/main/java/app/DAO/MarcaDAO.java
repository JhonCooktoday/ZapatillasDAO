package app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.Conexion.Conexion;
import app.Interfaces.IMarca;
import app.Modelo.Marca;

public class MarcaDAO implements IMarca {

	@Override
	public List<Marca> listarTodo() {
		List<Marca> listaMarcas = new ArrayList<Marca>();
		String sql = "SELECT * FROM Marca";
		Connection cnx = Conexion.getConexion();
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("idMarca");
				String nombre = rs.getString("nombreMarca");
				Marca marca = new Marca(id, nombre);
				listaMarcas.add(marca);
			}
			rs.close(); ps.close(); cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMarcas;
	}

}
