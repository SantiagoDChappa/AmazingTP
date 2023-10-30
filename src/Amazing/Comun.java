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
			if(listaPaquetes.size() < maxPaquetes && paquete instanceof Ordinario && !paquete.getEntregado()){
				Pedido nuevoPedido = new Pedido();
				nuevoPedido.setDireccion(pedido.getDireccion());
				nuevoPedido.setIdPedido(pedido.getIdPedido());
				paquete.entregado();

				listaPaquetes.put(paquete.getIdPaquete(), paquete);
				listaPedido.put(paquete.getIdPaquete(), nuevoPedido);
			}
		}
	}	

	public String toString(){
		String texto = "Transporte\nPatente: " + getPatente() + "\nTipo de transporte: Comun";
		if(listaPaquetes.size() > 0){
			for (Paquete paquete : listaPaquetes.values()) {
				Pedido pedido = listaPedido.get(paquete.getIdPaquete());
				texto += "\n[ Nro. Pedido: " + pedido.getIdPedido() + " - Cod. Paquete: " + paquete.getIdPaquete() + " ] " + pedido.getDireccion();
			}
		}else{
			texto += "\n VACIO";
		}
		return texto;
	}
}
