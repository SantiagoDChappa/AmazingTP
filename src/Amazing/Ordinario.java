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

    public Integer getCostoEnvio(){
        return this.costoEnvio;
    }

    public Boolean validarIgualdad(Ordinario otroPaquete){
        if(getVolumen().equals(otroPaquete.getVolumen()) && getPrecio().equals(otroPaquete.getPrecio()) && getEntregado() == otroPaquete.getEntregado() && costoEnvio.equals(otroPaquete.getCostoEnvio())){
            return true;
        }
        return false;
    }
}