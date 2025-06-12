package app.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.Conexion.Conexion;
import app.Interfaces.IZapatilla;
import app.Modelo.Marca;
import app.Modelo.Zapatilla;

public class ZapatillaDAO implements IZapatilla {

	@Override
	public void registrar(Zapatilla Zapatilla) {
		Conexion conex = new Conexion();
        String sql = "INSERT INTO Zapatilla (modelo, color, talla, precio, stock, genero, tipo, fechaIngreso, Marca_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conex.getConexion().prepareStatement(sql);
            ps.setString(1, Zapatilla.getModelo());
            ps.setString(2, Zapatilla.getColor());
            ps.setDouble(3, Zapatilla.getTalla());
            ps.setDouble(4, Zapatilla.getPrecio());
            ps.setInt(5, Zapatilla.getStock());
            ps.setString(6, Zapatilla.getGenero());
            ps.setString(7, Zapatilla.getTipo());
            ps.setDate(8, new java.sql.Date(Zapatilla.getFechaIngreso().getTime()));
            ps.setInt(9, Zapatilla.getMarca().getIdMarca());
            
            int x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("Zapatilla registrada en BD...");
            } else {
                System.out.println("Zapatilla NO registrada...");
            }
        } catch (SQLException e) {
           e.getMessage();
        }
    }

	@Override
	public Zapatilla buscarPorID(int id) {
		Zapatilla zapatillaBuscado = new Zapatilla();
		String sql = "{ CALL SP_BuscarZapatillaPorID(?) }";
		Connection cnx = Conexion.getConexion();
		try {
			CallableStatement cs = cnx.prepareCall(sql);
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			if (rs.next()) {
				zapatillaBuscado.setIdZapatilla(rs.getInt("idZapatilla"));
				zapatillaBuscado.setModelo(rs.getString("modelo"));
				zapatillaBuscado.setColor(rs.getString("color"));
				zapatillaBuscado.setTalla(rs.getDouble("talla"));
				zapatillaBuscado.setPrecio(rs.getDouble("precio"));
				zapatillaBuscado.setStock(rs.getInt("stock"));
				zapatillaBuscado.setGenero(rs.getString("genero"));
				zapatillaBuscado.setTipo(rs.getString("tipo"));
				zapatillaBuscado.setFechaIngreso(rs.getDate("fechaIngreso"));
				Marca marca = new Marca(rs.getInt("idMarca"), rs.getString("nombreMarca"));
				zapatillaBuscado.setMarca(marca);
			}
			rs.close(); cs.close(); cnx.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return zapatillaBuscado;
	}
	@Override
	public boolean actualizar(Zapatilla Zapatilla) {
		String sql = "UPDATE Zapatilla SET modelo = ?, color = ?, talla = ?, precio = ?, stock = ?, genero = ?, tipo = ?, fechaIngreso = ?, Marca_ID = ? WHERE idZapatilla = ?";
	    try (Connection conn = Conexion.getConexion();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, Zapatilla.getModelo());
	        ps.setString(2, Zapatilla.getColor());
	        ps.setDouble(3, Zapatilla.getTalla());
	        ps.setDouble(4, Zapatilla.getPrecio());
	        ps.setInt(5, Zapatilla.getStock());
	        ps.setString(6, Zapatilla.getGenero());
	        ps.setString(7, Zapatilla.getTipo());
	        ps.setDate(8, new java.sql.Date(Zapatilla.getFechaIngreso().getTime()));
	        ps.setInt(9, Zapatilla.getMarca().getIdMarca());
	        ps.setInt(10, Zapatilla.getIdZapatilla());

	        return ps.executeUpdate() > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	@Override
	public boolean eliminar(int id) {
		boolean eliminado = false;
	    String sql = "DELETE FROM Zapatilla WHERE idZapatilla = ?";
	    
	    try (Connection conn = Conexion.getConexion();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        
	        int filasAfectadas = ps.executeUpdate();
	        if (filasAfectadas > 0) {
	            eliminado = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return eliminado;
	}

	@Override
	public List<Zapatilla> buscarPorMarca(int marca_ID) {
		List<Zapatilla> lstZapatillas = new ArrayList<>();
		String sql = "{ CALL SP_ObtenerZapatillasPorMarca(?) }";
		Connection cnx = Conexion.getConexion();
		try {
			CallableStatement cs = cnx.prepareCall(sql);
			cs.setInt(1, marca_ID);
			ResultSet rs = cs.executeQuery();
		    while(rs.next()){
				//instanciamos la clase...
				Zapatilla zap=new Zapatilla();
				zap.setIdZapatilla(rs.getInt("idZapatilla"));
				zap.setModelo(rs.getString("modelo"));
				zap.setColor(rs.getString("color"));
				zap.setTalla(rs.getDouble("talla"));
				zap.setPrecio(rs.getDouble("precio"));
				zap.setStock(rs.getInt("stock"));
				zap.setGenero(rs.getString("genero"));
				zap.setTipo(rs.getString("tipo"));
				zap.setFechaIngreso(rs.getDate("fechaIngreso"));
				Marca marca = new Marca(marca_ID, rs.getString("nombreMarca"));
			    zap.setMarca(marca);
				//asignamos lo recuperado de la bd
				lstZapatillas.add(zap);
			} //fin del bucle...
					
		    rs.close(); cs.close(); cnx.close();
					
		}catch(SQLException e){
			e.printStackTrace();
		}  //fin del catch...
		//retornamos el listado
		return lstZapatillas;
	}//fin del metodo listar...

}
