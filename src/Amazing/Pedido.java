package Amazing;

import java.util.Hashtable;

public class Pedido{
    private Integer idPedido;
    private Hashtable<Integer,Paquete> paquetes;
    private Integer documentoCliente;
    private String nombreCliente;
    private String direccionCliente;
}