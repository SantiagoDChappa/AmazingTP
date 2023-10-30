package Amazing;

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

    public boolean mismaCarga(Paquete otroPaquete) {
        return this.volumen.equals(otroPaquete.volumen) && this.precio.equals(otroPaquete.precio);

    }
    public static boolean sonMismoTipo(Paquete paquete1, Paquete paquete2) {
        if (paquete1 instanceof Especial && paquete2 instanceof Especial) {
            return true; // Ambos son de tipo Especial.
        } else if (paquete1 instanceof Ordinario && paquete2 instanceof Ordinario) {
            return true; // Ambos son de tipo Ordinario.
        } else {
            return false; // Son de tipos diferentes.
        }
    }

    public Boolean validarIgualdad(Paquete otroPaquete){
        if(volumen.equals(otroPaquete.volumen) && precio.equals(otroPaquete.precio) && entregado == otroPaquete.entregado){
            return true;
        }
        return false;
    }

    public String toString(){
        return "Numero de paquete: " + idPaquete + ", Volumen: " + volumen + ", precio: " + precio + " y entregado: " + entregado;
    }
}