package Amazing; 

import java.util.ArrayList;
import java.util.Hashtable;

public abstract class Transporte {
	
	private String patente;
	private int volumenMaximo;
	private double valorDeViaje;
	protected Hashtable<Integer, Paquete> listaPaquetes;
	protected Hashtable<Integer, Pedido> listaPedido;
	
	public Transporte (String patente, int volumenMaximo, int valorDeViaje) {
		this.patente = patente;
		this.volumenMaximo = volumenMaximo;
		this.listaPaquetes = new Hashtable<Integer, Paquete>();		
		this.listaPedido = new Hashtable<Integer, Pedido>();
		this.valorDeViaje = valorDeViaje;
	}

	public int getVolumenMaximo() {
		return volumenMaximo;
	}

	public abstract double calcularValorEntrega();
	
	public double getValorDeViaje() {
		return valorDeViaje;
	}

	public Hashtable<Integer, Paquete> getListaPaquete() {
		return this.listaPaquetes;
	}
	
	public abstract void cargarPaquetes(Pedido pedido);
	
	public boolean mismaCarga(Transporte otroTransporte) {
		Hashtable<Integer, Paquete> listaPaquete2 = otroTransporte.getListaPaquete();
		Boolean ret = false;
		Boolean ret2 = true;

		for (Paquete paquete : listaPaquetes.values()) {
			ret = false;
			for (Paquete paquete2 : listaPaquete2.values()) {
					ret = ret || paquete.validarIgualdad(paquete2);
			}
			ret2 = ret2 && ret;
		}
		return ret2;
    }

    public boolean sonMismoTipo(Transporte transporte1, Transporte transporte2) {
        if ((transporte1 instanceof Camion) && (transporte2 instanceof Camion)) {
            return true; // Ambos son de tipo Camion.
        } else if ((transporte1 instanceof Comun) && (transporte2 instanceof Comun)) {
            return true; // Ambos son de tipo Comun.
        } else if ((transporte1 instanceof Utilitario) && (transporte2 instanceof Utilitario)) {
            return true; // Ambos son de tipo Utilitario.
        } else {
            return false; // Son de tipos diferentes.
        }
    }

	public abstract String toString();

	public String getPatente(){
		return this.patente;
	}	
}