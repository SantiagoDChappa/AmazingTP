package Amazing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
			if(paquete.getVolumen() > 2000 && paquete instanceof Especial && !paquete.getEntregado()){
				Pedido nuevoPedido = new Pedido();
				nuevoPedido.setDireccion(pedido.getDireccion());
				nuevoPedido.setIdPedido(pedido.getIdPedido());
				paquete.entregado();
				
				listaPaquetes.put(paquete.getIdPaquete(), paquete);
				listaPedido.put(paquete.getIdPaquete(), nuevoPedido);
			}
		}
	}	
}
