package Amazing;

public class Ordinario extends Paquete{
    private Integer costoEnvio;

    public Ordinario(Integer idPaquete, Integer volumen, Integer precio, Integer costoEnvio){
        super(idPaquete, volumen, precio);
        this.costoEnvio = costoEnvio;
    }

    public Integer calcularValorTotal(){
        return getPrecio() + costoEnvio;
    }
}
