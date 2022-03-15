package servidor.modelo.dominio;

public class AdministradorDTO {
    private String login;
    private String clave;
    
    public AdministradorDTO() {
    }
    
    public AdministradorDTO(String login, String clave) {
        this.login = login;
        this.clave = clave;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
