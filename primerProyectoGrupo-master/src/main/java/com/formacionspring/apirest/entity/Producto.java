package com.formacionspring.apirest.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, name="Nombre", length= 50)
	private String nombre;
	
	@Column(nullable = false,unique=true)
	private String CodProducto;
	
	@Column(nullable = false, length= 50)
	private String Tipo;
	
	private double Precio;
	
	@Column(name="Fecha_registro")
	private Date createAt;
	
	@Column(name="Cantidad")
	private int cantidad;
	
	@Column(name="Imagen")
	private String imagen;
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCodProducto() {
		return CodProducto;
	}



	public void setCodProducto(String codProducto) {
		CodProducto = codProducto;
	}



	public String getTipo() {
		return Tipo;
	}



	public void setTipo(String tipo) {
		Tipo = tipo;
	}



	public double getPrecio() {
		return Precio;
	}



	public void setPrecio(Double precio) {
		Precio = precio;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
