package app.Modelo;


import java.util.Date;

public class Empleado {
	private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private Date fechaContratacion;
    private double salario;

    
    
    
    
    
	public Empleado() {
		
	}
	
	
	public Empleado(int id, String nombre, String apellido, String correo, String telefono, String direccion,
			Date fechaContratacion, double salario) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaContratacion = fechaContratacion;
		this.salario = salario;
		
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
    
    
    
    
    
}
