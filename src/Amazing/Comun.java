package Amazing;

import java.util.Hashtable;

public class Comun extends Transporte {
	private int maxPaquetes;
	
	public Comun(String patente, int volumenMaximo, int valorDeViaje, int maxPaquetes) {
		super(patente, volumenMaximo, valorDeViaje);
		this.maxPaquetes=maxPaquetes;
	}
	
	public boolean puedeTransportarPaquete(Paquete paquete) {
		return (paquete instanceof Ordinario && paquete.getVolumen() <= 2000);
	}

	@Override
    public double calcularValorEntrega() {
		return getValorDeViaje();
    }
	
	public void cargarPaquetes(Pedido pedido){
		Hashtable<Integer, Paquete> paquetes = pedido.getPaquetes();
		for (Paquete paquete : paquetes.values()) {
			if(listaPaquetes.size() < maxPaquetes && paquete instanceof Ordinario){
				listaPaquetes.put(paquete.getIdPaquete(), paquete);
			}
		}
	}	

}
