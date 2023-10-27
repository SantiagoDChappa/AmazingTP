package Amazing;

public class Especial extends Paquete{
    private Integer valorAdicional;
    private Integer procentajeEntregaRapida;

    public Especial(Integer idPaquete, Integer volumen, Integer precio, Integer porcentaje, Integer adicional){
        super(idPaquete, volumen, precio);
        this.valorAdicional = adicional;
        this.procentajeEntregaRapida = porcentaje;
    }
}
