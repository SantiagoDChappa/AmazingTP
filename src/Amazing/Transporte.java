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

		if(!sonMismoTipo(this, otroTransporte)){
			return false;
		}

		if (this.volumenMaximo != otroTransporte.volumenMaximo || 
            this.valorDeViaje != otroTransporte.valorDeViaje) {
            return false;
        }

		// Comparar las listas de paquetes
        if (!sonListasIdenticas(this.listaPaquetes, otroTransporte.listaPaquetes)) {
            return false;
        }

		// Comparar las listas de pedidos
		if (!sonListasIdenticas(this.listaPedido, otroTransporte.listaPedido)) {
			return false;
		}
		return true;
    }


    private <T> boolean sonListasIdenticas(Hashtable<Integer, T> lista1, Hashtable<Integer, T> lista2) {
        if (lista1 == null && lista2 == null) {
            return true;
        }
        if (lista1 == null || lista2 == null) {
            return false;
        }
        if (lista1.size() != lista2.size()) {
            return false;
        }
        
        // Verificar si los elementos de las listas son iguales
        for (Integer key : lista1.keySet()) {
            if (!lista2.containsKey(key) || !Objects.equals(lista1.get(key), lista2.get(key))) {
                return false;
            }
        }

        return true;
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