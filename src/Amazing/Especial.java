package Amazing;

public class Especial extends Paquete{
    private Integer valorAdicional;
    private Integer porcentajeEntregaRapida;

    public Especial(Integer idPaquete, Integer volumen, Integer precio, Integer porcentaje, Integer adicional){
        super(idPaquete, volumen, precio);
        this.valorAdicional = adicional;
        this.porcentajeEntregaRapida = porcentaje;
    }

    public Integer getPorcentajeEntregaRapida(){
        return this.porcentajeEntregaRapida;
    }

    public Integer getValorAdicional(){
        return this.valorAdicional;
    }
    
    public Boolean validarIgualdad(Especial otroPaquete){
        if(getVolumen().equals(otroPaquete.getVolumen()) && getPrecio().equals(otroPaquete.getPrecio()) && getEntregado() == otroPaquete.getEntregado() && valorAdicional.equals(otroPaquete.getValorAdicional()) && porcentajeEntregaRapida.equals(otroPaquete.getPorcentajeEntregaRapida())){
            return true;
        }
        return false;
    }

    public Integer calcularValorTotal(){
        if (getVolumen() < 3000) {
            return getPrecio() + ((getPrecio() * porcentajeEntregaRapida) / 100);
        }else if(getVolumen() >= 3000 && getVolumen() <= 5000){
            return getPrecio() + ((getPrecio() * porcentajeEntregaRapida) / 100) + valorAdicional;
        }else{
            return getPrecio() + ((getPrecio() * porcentajeEntregaRapida) / 100) + (valorAdicional*2);
        }
    }
}
