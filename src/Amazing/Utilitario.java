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
			listaPaquetes.put(paquete.getIdPaquete(), paquete);
		}
	}	

}
