package Amazing;

public class Especial extends Paquete{
    private Integer valorAdicional;
    private Integer porcentajeEntregaRapida;

    public Especial(Integer idPaquete, Integer volumen, Integer precio, Integer porcentaje, Integer adicional){
        super(idPaquete, volumen, precio);
        this.valorAdicional = adicional;
        this.porcentajeEntregaRapida = porcentaje;
    }

    public Integer calcularValorTotal(){
        if (getVolumen() <= 3000) {
            return getPrecio() + ((getPrecio() * porcentajeEntregaRapida) / 100);
        }else if(getVolumen() > 3000 && getVolumen() <= 5000){
            return getPrecio() + ((getPrecio() * porcentajeEntregaRapida) / 100) + valorAdicional;
        }else{
            return getPrecio() + ((getPrecio() * porcentajeEntregaRapida) / 100) + (valorAdicional*2);
        }
    }
}
