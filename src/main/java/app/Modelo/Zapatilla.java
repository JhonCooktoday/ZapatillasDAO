package app.Modelo;

import java.util.Date;

public class Zapatilla {
	private int idZapatilla;
    private String modelo;
    private String color;
    private double talla;
    private double precio;
    private int stock;
    private String genero;
    private String tipo;
    private Date fechaIngreso;
    private String img_Zapatilla;
    private Marca marca;
    
    
	public Zapatilla() {
	idZapatilla = 0;
	modelo = "";
	color = "";
	talla = 0;
	precio = 0;
	stock = 0;
	genero = "";
	tipo = "";
	fechaIngreso = new Date();
	img_Zapatilla = "";
	marca = new Marca();
	}


	public Zapatilla(String modelo, String color, double talla, double precio, int stock,
			String genero, String tipo, Date fechaIngreso, String img_Zapatilla, Marca marca) {
		idZapatilla = 0;
		this.modelo = modelo;
		this.color = color;
		this.talla = talla;
		this.precio = precio;
		this.stock = stock;
		this.genero = genero;
		this.tipo = tipo;
		this.fechaIngreso = fechaIngreso;
		this.img_Zapatilla = img_Zapatilla;
		this.marca = marca;
	}

	public Zapatilla(int idZapatilla, String modelo, String color, double talla, double precio, int stock,
			String genero, String tipo, Date fechaIngreso, String img_Zapatilla, Marca marca) {
		this.idZapatilla = idZapatilla;
		this.modelo = modelo;
		this.color = color;
		this.talla = talla;
		this.precio = precio;
		this.stock = stock;
		this.genero = genero;
		this.tipo = tipo;
		this.fechaIngreso = fechaIngreso;
		this.img_Zapatilla = img_Zapatilla;
		this.marca = marca;
	}


	
	
	public int getIdZapatilla() {
		return idZapatilla;
	}


	public void setIdZapatilla(int idZapatilla) {
		this.idZapatilla = idZapatilla;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getTalla() {
		return talla;
	}


	public void setTalla(double talla) {
		this.talla = talla;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public String getImg_Zapatilla() {
		return img_Zapatilla;
	}


	public void setImg_Zapatilla(String img_Zapatilla) {
		this.img_Zapatilla = img_Zapatilla;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "Zapatilla [idZapatilla=" + idZapatilla + ", modelo=" + modelo + ", color=" + color + ", talla=" + talla
				+ ", precio=" + precio + ", stock=" + stock + ", genero=" + genero + ", tipo=" + tipo
				+ ", fechaIngreso=" + fechaIngreso + ", img_Zapatilla=" + img_Zapatilla +", marca=" + marca + "]";
	}
    
}
