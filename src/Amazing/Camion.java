package Amazing;

import java.util.Hashtable;

public class Camion extends Transporte {
	private int adicionalPorPaquete;
	
	

	public Camion(String patente, int volumenMaximo, int valorDeViaje, int adicionalPorPaquete) {
		super(patente, volumenMaximo, valorDeViaje); //en super pasar sólo los parametros de transporte
		this.adicionalPorPaquete=adicionalPorPaquete;
		
	}
	public boolean puedeTransportarPaquete(Paquete paquete) {
		return (paquete instanceof Especial && paquete.getVolumen() >= 2000);
	}
	
	@Override
    public double calcularValorEntrega() {
		return getValorDeViaje() +(adicionalPorPaquete * listaPaquetes.size());
    }	// 			100				,10						5	

	public void cargarPaquetes(Pedido pedido){
		Hashtable<Integer, Paquete> paquetes = pedido.getPaquetes();
		for (Paquete paquete : paquetes.values()) {
			if(paquete.getVolumen() > 2000 && paquete instanceof Especial){
				listaPaquetes.put(paquete.getIdPaquete(), paquete);
			}
		}
	}	

}
