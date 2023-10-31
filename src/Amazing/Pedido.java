package Amazing;

import java.util.*;

public class Pedido{
    private Integer idPedido;
    private Hashtable<Integer,Paquete> paquetes;
    private Integer documentoCliente;
    private String nombreCliente;
    protected String direccionCliente;
    private Boolean finalizado;

    
    public Pedido(){
        this.nombreCliente = null;
        this.direccionCliente = null;
        this.documentoCliente = 0;
        this.paquetes = new Hashtable<Integer, Paquete>();
        this.idPedido = 0;
        this.finalizado = false;

    }

    public Pedido(String cliente, String direccion, Integer documento, Integer idPedido){
        this.nombreCliente = cliente;
        this.direccionCliente = direccion;
        this.documentoCliente = documento;
        this.paquetes = new Hashtable<Integer, Paquete>();
        this.idPedido = idPedido;
        this.finalizado = false;
        
    }
    public void finalizarPedido(){
        this.finalizado = true;
    }

    public boolean validarFinalizado(){
        return this.finalizado;
    }

    public void quitarPaquete(Integer codPaquete){
        paquetes.remove(codPaquete);
    }

    public String getDireccion(){
        return this.direccionCliente;
    }

    public void setDireccion(String direccion){
        this.direccionCliente = direccion;
    }

    public void agregarPaquete(Integer idPaquete, Paquete paquete){
        paquetes.put(idPaquete, paquete);
    }

    public Integer getIdPedido(){
        return this.idPedido;
    }

     public void setIdPedido(Integer idPedido){
        this.idPedido = idPedido;
    }

    public Integer obtenerFacturacion(){
        Integer precioFinal = 0;
        for (Paquete paquete : paquetes.values()) {
                precioFinal += paquete.calcularValorTotal();
            }
        return precioFinal;
    }

    public Hashtable<Integer, Paquete> getPaquetes(){
        return this.paquetes;
    }

    public boolean validarPedido(Integer codPaquete){
        for (Paquete paquete : paquetes.values()) {
            if (paquete.getIdPaquete().equals(codPaquete)) {
                return true;
            }
        }
        return false;
    }


    public boolean tieneNoEntregados(){
        for (Paquete paquete : paquetes.values()) {
            if (!paquete.getEntregado()) {
                return true;
            }
        }
        return false;
    }

    public String getNombreCliente(){
        return this.nombreCliente;
    }

    public String toString(){
        return "Nombre: " + this.nombreCliente + ", Direccion: " + direccionCliente +", Documento: " + documentoCliente + " y Numero de Pedido: " + idPedido;
    }
}