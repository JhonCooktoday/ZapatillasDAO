package app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.Conexion.Conexion;
import app.Modelo.Empleado;


public class EmpleadoDAO implements app.Interfaces.IEmpleado{

	@Override
	public void registrar(Empleado e) {
		  String sql = "INSERT INTO empleados (nombre, apellido, correo, telefono, direccion, fecha_contratacion, salario) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    try (
		    		
		    	Connection conn = Conexion.getConexion();
		         PreparedStatement ps = conn.prepareStatement(sql)) {
		        
		        // Establecer los parámetros
		        ps.setString(1, e.getNombre());
		        ps.setString(2, e.getApellido());
		        ps.setString(3, e.getCorreo());
		        ps.setString(4, e.getTelefono());
		        ps.setString(5, e.getDireccion());
		        ps.setDate(6,  new java.sql.Date(e.getFechaContratacion().getTime())); 
		        ps.setDouble(7, e.getSalario());
	

		        int x=ps.executeUpdate();
				if(x>0){
					//emitimos por consola 
					System.out.println("Producto registrado en BD...");
				}else{
					System.out.println("Producto NO registrado en BD...");
				} // Retorna true si la inserción fue exitosa
		    } catch (SQLException en) {
		        en.printStackTrace();
		    }
		
		
	}
	

	public Empleado buscarPorID(int id) {
	    Empleado empleado = null;
	    String sql = "SELECT id, nombre, apellido, correo, telefono, direccion, fecha_contratacion, salario FROM empleados WHERE id = ?";
	    Connection cnx = Conexion.getConexion();

	    try (PreparedStatement ps = cnx.prepareStatement(sql)) {
	        // Establecemos el parámetro ID en la consulta
	        ps.setInt(1, id);
	        
	        // Ejecutamos la consulta
	        ResultSet rs = ps.executeQuery();
	        
	        // Si hay un registro, lo mapeamos
	        if (rs.next()) {
	            empleado = new Empleado();
	            empleado.setId(rs.getInt("id"));  // Recupera el ID
	            empleado.setNombre(rs.getString("nombre"));  // Recupera el nombre
	            empleado.setApellido(rs.getString("apellido"));  // Recupera el apellido
	            empleado.setCorreo(rs.getString("correo"));  // Recupera el correo
	            empleado.setTelefono(rs.getString("telefono"));  // Recupera el teléfono
	            empleado.setDireccion(rs.getString("direccion"));  // Recupera la dirección
	            empleado.setFechaContratacion(rs.getDate("fecha_contratacion"));  // Recupera la fecha de contratación
	            empleado.setSalario(rs.getDouble("salario"));  // Recupera el salario
	        }

	        rs.close();  // Cerramos el ResultSet
	    } catch (SQLException e) {
	        e.printStackTrace();  // Manejamos cualquier error SQL
	    }
	    
	    return empleado;  // Retornamos el empleado encontrado
	}

	

	

	


	@Override
	public List<Empleado> listar() {
		 List<Empleado> lista = new ArrayList<>();
		    String sql = "SELECT * FROM empleados";
		    Connection cnx = Conexion.getConexion();

		    try {
		        PreparedStatement ps = cnx.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		            Empleado emp = new Empleado();
		            emp.setId(rs.getInt("id"));
		            emp.setNombre(rs.getString("nombre"));
		            emp.setApellido(rs.getString("apellido"));
		            emp.setCorreo(rs.getString("correo"));
		            emp.setTelefono(rs.getString("telefono"));
		            emp.setDireccion(rs.getString("direccion"));
		            emp.setFechaContratacion(rs.getDate("fecha_contratacion"));
		            emp.setSalario(rs.getDouble("salario"));
		            lista.add(emp);
		        }
		        rs.close();
		        ps.close();
		        cnx.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return lista;
	}


	@Override
	public void eliminar(Empleado e) {
		Connection cnx = Conexion.getConexion();
		String sql = "delete from empleados where id=?";
		//aplicamos la interface Preparedstatement..
		PreparedStatement ps= null;		
		try{
			//asignamos la conexion y la cadena
			ps=cnx.prepareStatement(sql);
			//asignamos el parametro
			ps.setInt(1,e.getId());
			//ejecutamos
			int x=ps.executeUpdate();
			//aplicamos una condicion...
			if(x>0){
				//emitimos un mensaje
				System.out.println("registro eliminado de la BD");
			}else{
				System.out.println("registro NO eliminado de la BD");
			} //fin del else...
		}catch(SQLException n){
			System.out.println(n.getMessage());
		}//fin del catch...
		
	}


	@Override
	public void actualizar(Empleado e) {
	    Connection cnx = Conexion.getConexion();
	    String sql = "UPDATE empleados SET nombre=?, apellido=?, correo=?, telefono=?, direccion=?, fecha_contratacion=?, salario=? WHERE id=?";
	    PreparedStatement ps = null;
	    try {
	        ps = cnx.prepareStatement(sql);
	        
	        
	        
	        
	        ps.setString(1, e.getNombre());
	        ps.setString(2, e.getApellido());
	        ps.setString(3, e.getCorreo());
	        ps.setString(4, e.getTelefono());
	        ps.setString(5, e.getDireccion());
	        ps.setDate(6, new java.sql.Date(e.getFechaContratacion().getTime()));
	        ps.setDouble(7, e.getSalario());
	        ps.setInt(8, e.getId());
	        
	        int x = ps.executeUpdate();
	        
	        if (x > 0) {
	            System.out.println("Empleado actualizado en la BD...");
	        } else {
	            System.out.println("Empleado NO actualizado en la BD...");
	        }
	    } catch (SQLException en) {
	        en.printStackTrace();
	    }
	}
	
	public List<Empleado> listarpdf() {
	    List<Empleado> lista = new ArrayList<>();
	    try {
	        Connection con = Conexion.getConexion();
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM empleados");
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            Empleado e = new Empleado();
	            e.setId(rs.getInt("id"));
	            e.setNombre(rs.getString("nombre"));
	            e.setApellido(rs.getString("apellido"));
	            e.setCorreo(rs.getString("correo"));
	            e.setTelefono(rs.getString("telefono"));
	            e.setSalario(rs.getDouble("salario"));
	            lista.add(e);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return lista;
	}

	

	
	

}
