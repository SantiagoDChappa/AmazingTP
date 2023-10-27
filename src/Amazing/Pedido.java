package Amazing;

import java.util.*;
import java.util.Iterator;

public class Pedido{
    private Integer idPedido;
    private Hashtable<Integer,Paquete> paquetes;
    private Integer documentoCliente;
    private String nombreCliente;
    private String direccionCliente; 

    
    public Pedido(){
        this.nombreCliente = null;
        this.direccionCliente = null;
        this.documentoCliente = 0;
        this.paquetes = new Hashtable<Integer, Paquete>();
        this.idPedido = 0;
    }

    public Pedido(String cliente, String direccion, Integer documento, Integer idPedido){
        this.nombreCliente = cliente;
        this.direccionCliente = direccion;
        this.documentoCliente = documento;
        this.paquetes = new Hashtable<Integer, Paquete>();
        this.idPedido = idPedido+1;
    }

    public void agregarPaquete(Paquete paquete){
        paquetes.put(paquete.getIdPaquete(), paquete);
        System.out.println(paquetes.size());
    }

    public Integer getIdPedido(){
        return this.idPedido;
    }

    public String getPaquetes(){
        Iterator it = paquetes.entrySet().iterator();
        String listado = "Paquetes: ";
        while(it.hasNext()){
            Object claveValor = it.next();
            listado += "{" + claveValor +  "}";
        }
        return listado;
    }

    public String toString(){
        return "Nombre: " + this.nombreCliente + ", Direccion: " + direccionCliente +", Documento: " + documentoCliente + " y Numero de Pedido: " + idPedido;
    }
}