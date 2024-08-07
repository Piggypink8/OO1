package ar.edu.unlp.info.oo1.Ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Distribuidora {
	private double precioKWh;
	private List<Usuario> usuarios;
	
	
	
	public Distribuidora(double precioKWh) {
		this.precioKWh = precioKWh;
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public List<Factura> facturar() {
		return this.usuarios.stream()
				.map(usuario -> usuario.facturarEnBaseA(this.precioKWh))
				.collect(Collectors.toList());
	}
	
	public List<Usuario> getUsuarios (){
		return this.usuarios;
	}
	
	public double consumoTotalActiva() {
		return this.usuarios.stream().mapToDouble(usuario -> usuario.ultimoConsumoActiva()).sum();
	}
	
	public double getPrecioKWh() {
		 return this.precioKWh;
	}
}
