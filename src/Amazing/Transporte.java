package Amazing; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

		if(this.getClass() != otroTransporte.getClass()){
			return false;
		}

		if (this.listaPaquetes.size() != otroTransporte.listaPaquetes.size() || (otroTransporte.listaPaquetes.size() == 0 && this.listaPaquetes.size() == 0)) {
			return false;
		}
		
		// Comparar las listas de paquetes
		for(Paquete paquete : this.listaPaquetes.values()){
			for(Paquete paquete2 : otroTransporte.listaPaquetes.values()){
				if (paquete.getClass() == paquete2.getClass() && paquete.getClass() == (Especial.class)) {
					Especial especial = (Especial)paquete;
					Especial especial2 = (Especial)paquete2;
					return especial.cargaIdentica(especial2);
				}else if(paquete.getClass() == paquete2.getClass() && paquete.getClass() == (Ordinario.class)){
					Ordinario ordinario = (Ordinario)paquete;
					Ordinario ordinario2 = (Ordinario)paquete2;
					return ordinario.cargaIdentica(ordinario2);
				}
			}
		}

		return true;
    }

	public String toString(){
		String texto = "";

        List<Integer> claves = new ArrayList<>(listaPaquetes.keySet());

        Collections.sort(claves);

		System.out.println(listaPaquetes.values());

		if(listaPaquetes.size() > 0){
			for (Integer clave : claves) {
					Paquete paquete = listaPaquetes.get(clave);
					Pedido pedido = listaPedido.get(paquete.getIdPaquete());
					texto += " + [ " + pedido.getIdPedido() + " - " + paquete.getIdPaquete() + " ] " + pedido.getDireccion() + "\n";
			}
		}
		return texto;
	}

	public String getPatente(){
		return this.patente;
	}	
}