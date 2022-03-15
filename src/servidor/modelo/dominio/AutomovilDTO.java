package servidor.modelo.dominio;

public class AutomovilDTO {
    private String placa;
    private String marca;
    private String linea;
    private String tipoCarroceria;
    private String tipoCombustible;
    private String color;
    private String descripcion;
    private TipoAutoDTO objTipoAuto;
    private boolean estado;
    private float modelo;
    private float valor;
    private int numeroPuertas;
    private int kilometraje;

    public AutomovilDTO(String placa, String marca, String linea, String tipoCarroceria, String tipoCombustible, String color, String descripcion, TipoAutoDTO objTipoAuto, boolean estado, float modelo, float valor, int numeroPuertas, int kilometraje) {
        this.placa = placa;
        this.marca = marca;
        this.linea = linea;
        this.tipoCarroceria = tipoCarroceria;
        this.tipoCombustible = tipoCombustible;
        this.color = color;
        this.descripcion = descripcion;
        this.objTipoAuto = objTipoAuto;
        this.estado = estado;
        this.modelo = modelo;
        this.valor = valor;
        this.numeroPuertas = numeroPuertas;
        this.kilometraje = kilometraje;
    }

    public AutomovilDTO() {
       
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoAutoDTO getObjTipoAuto() {
        return objTipoAuto;
    }

    public void setObjTipoAuto(TipoAutoDTO objTipoAuto) {
        this.objTipoAuto = objTipoAuto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public float getModelo() {
        return modelo;
    }

    public void setModelo(float modelo) {
        this.modelo = modelo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    
    
}





