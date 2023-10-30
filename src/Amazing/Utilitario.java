package Amazing;

import java.util.Hashtable;

public class Utilitario extends Transporte{
	private int valorAdicional;

	public Utilitario(String patente, int volumenMaximo, int valorDeViaje, int valorAdicional) {
		super(patente, volumenMaximo, valorDeViaje);
		this.valorAdicional=valorAdicional;
	}
	@Override
    public double calcularValorEntrega() {
		if (this.listaPaquetes.size() > 10) {
			return valorAdicional + getValorDeViaje();
		}
		return getValorDeViaje();
			
    }
	
	public void cargarPaquetes(Pedido pedido){
		Hashtable<Integer, Paquete> paquetes = pedido.getPaquetes();
		for (Paquete paquete : paquetes.values()) {
			if(!paquete.getEntregado()){
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
		String texto = "Transporte\nPatente: " + getPatente() + "\nTipo de transporte: Utilitario";

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
