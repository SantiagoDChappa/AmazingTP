package Amazing;

import java.util.*;

public interface EmpresaAmazing{
    private Integer cuitSistema;
    private Hashtable<Integer, Paquete> paquetes;
    private ArrayList<Pedido> pedidos;

    public void crear(String cuit){
        this.cuitSistema = cuit;
        this.paquetes = null;
        // this.pedidos = new ArrayList<Pedido>();
    }
}
