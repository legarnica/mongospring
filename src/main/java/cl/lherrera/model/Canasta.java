package cl.lherrera.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Canasta implements Serializable {

	private static final long serialVersionUID = -243556683813488458L;

	@Id
	private String id;

	private String nombre;
	private String precio;
	private String detalle;
	private String urlImg;

	@DBRef
	private Set<Producto> productos = new HashSet<>();

	public Canasta() {
	}

	public Canasta(String id, String nombre, String precio, String detalle, String urlImg, Set<Producto> productos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.detalle = detalle;
		this.urlImg = urlImg;
		this.productos = productos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Canasta [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", detalle=" + detalle + ", urlImg="
				+ urlImg + ", productos=" + productos + "]";
	}

}
