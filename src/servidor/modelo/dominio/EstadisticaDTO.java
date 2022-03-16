package servidor.modelo.dominio;


public class EstadisticaDTO {
    private float promedioCodigosLibro;
    private float sumaCodigosLibro;

    public EstadisticaDTO() {
    }
        
    public EstadisticaDTO(float promedioCodigosLibro, float sumaCodigosLibro) {
        this.promedioCodigosLibro = promedioCodigosLibro;
        this.sumaCodigosLibro = sumaCodigosLibro;
    }

    public float getPromedioCodigosLibro() {
        return promedioCodigosLibro;
    }

    public void setPromedioCodigosLibro(float promedioCodigosLibro) {
        this.promedioCodigosLibro = promedioCodigosLibro;
    }

    public float getSumaCodigosLibro() {
        return sumaCodigosLibro;
    }

    public void setSumaCodigosLibro(float sumaCodigosLibro) {
        this.sumaCodigosLibro = sumaCodigosLibro;
    }
    
    
}
