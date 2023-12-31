package Amazing;

import java.util.Hashtable;
import java.util.Objects;

public class Paquete{
    private Integer volumen;
    private Integer idPaquete;
    private Boolean entregado;
    private Integer precio;

    public Paquete(Integer idPaquete, Integer volumen, Integer precio){
        this.idPaquete = idPaquete;
        this.volumen = volumen;
        this.entregado = false;
        this.precio = precio;
    }

    public Integer getIdPaquete(){
        return this.idPaquete;
    }

    public Integer getPrecio(){
        return this.precio;
    }

    public Integer getVolumen(){
        return this.volumen;
    }

    public void entregado(){
        this.entregado = true;
    }

    public boolean getEntregado(){
        return this.entregado;
    }

    public Integer calcularValorTotal(){
        return precio;
    }

    public String toString(){
        return "Numero de paquete: " + idPaquete + ", Volumen: " + volumen + ", precio: " + precio + " y entregado: " + entregado;
    }
}