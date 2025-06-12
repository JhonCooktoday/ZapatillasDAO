package app.DAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import app.Conexion.Conexion;
import app.Interfaces.Ilogin;
import app.Modelo.Usuario;

public class LoginDao implements Ilogin{
	
	Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
	@Override
	public Usuario validar(String nombreUsuario, String contrasena) {
		Usuario usuario = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConexion();
            String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contrasena = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasena);

            rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }

        return usuario;
    }

	@Override
	public void insertar(Usuario u) {
		// Llamamos al método de la clase Conexion para obtener la conexión
        Connection con = Conexion.getConexion(); // Obtenemos la conexión

        // Si la conexión es null, no intentamos insertar
        if (con == null) {
            System.out.println("❌ No se pudo establecer conexión con la base de datos.");
            return;
        }

        String sql = "INSERT INTO usuario(nombre_usuario, contrasena,foto) VALUES (?, ?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getContrasena());
            ps.setBlob(3, u.getFoto());
            ps.executeUpdate();
            System.out.println("✅ Persona insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close(); // Cerramos la conexión
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}

	@Override
	public void listarImg(int id, HttpServletResponse response) {
		 String sql = "SELECT foto FROM usuario WHERE id = ?";
	        InputStream inputstream = null;
	        OutputStream outputstream = null;
	        BufferedInputStream bufferedInputStream = null;
	        BufferedOutputStream bufferedOutputStream = null;

	        response.setContentType("image/*");  // Esto le dice al navegador que la respuesta es una imagen

	        try {
	            outputstream = response.getOutputStream();
	            con = Conexion.getConexion();
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, id);  // Parametriza la consulta para evitar SQL injection
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                inputstream = rs.getBinaryStream("foto");  // Obtiene el flujo de la imagen de la BD
	                bufferedInputStream = new BufferedInputStream(inputstream);
	                bufferedOutputStream = new BufferedOutputStream(outputstream);

	                int i = 0;
	                while ((i = bufferedInputStream.read()) != -1) {
	                    bufferedOutputStream.write(i);  // Escribe la imagen al flujo de salida
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();  // Si ocurre un error, lo mostramos en los logs
	        } finally {
	            try {
	                if (bufferedInputStream != null) bufferedInputStream.close();
	                if (bufferedOutputStream != null) bufferedOutputStream.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		
	}
	

}
