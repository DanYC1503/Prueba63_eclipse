package Prueba63.Prueba63.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.Serializable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Deuda implements Serializable {

	@Id
	@GeneratedValue
	private int codigo;
	private String numero;
	
	private String cedula;
	
	private double total;
	private Date fechaEmision;
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="codigo_compra")
	private List<DetalleDeuda> detalles;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void addDetalle(DetalleDeuda detalle) {
		if(detalles == null)
			detalles = new ArrayList<DetalleDeuda>();
		
		detalles.add(detalle);
	}
	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", numero=" + numero + ", cedula=" + cedula + ", total=" + total
				+ ", fechaEmision=" + fechaEmision + ", detalles=" + detalles + "]";
	}
	
	
	
	
}
