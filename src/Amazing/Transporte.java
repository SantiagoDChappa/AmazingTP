package Amazing; 

import java.util.ArrayList;
import java.util.Hashtable;

public abstract class Transporte {
	
	private String patente;
	private int volumenMaximo;
	private double valorDeViaje;
	protected Hashtable<Integer, Paquete> listaPaquetes;
	
	public Transporte (String patente, int volumenMaximo, int valorDeViaje) {
		this.patente = patente;
		this.volumenMaximo = volumenMaximo;
		this.listaPaquetes = new Hashtable<Integer, Paquete>();
		this.valorDeViaje = valorDeViaje;
	}

	public int getVolumenMaximo() {
		return volumenMaximo;
	}

	public abstract double calcularValorEntrega();
	
	public double getValorDeViaje() {
		return valorDeViaje;
	}
	
	public abstract void cargarPaquetes(Pedido pedido);
	
}