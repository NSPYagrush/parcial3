package servidor.servicios;

import com.google.gson.Gson;
import java.util.LinkedList;
import servidor.capaAccesoDatos.AdministradorDAO;
import servidor.capaAccesoDatos.AutomovilDAO;
import servidor.capaAccesoDatos.TipoAutomovilDAO;
import servidor.modelo.dominio.AdministradorDTO;
import servidor.modelo.dominio.EstadisticaDTO;
import servidor.modelo.dominio.AutomovilDTO;
import servidor.modelo.dominio.TipoAutoDTO;
import servidor.modelo.peticion.PeticionDTO;

public class Controlador {
    
    private final AutomovilDAO objLibroDAO;
    private final AdministradorDAO objAdministradorDAO;
    private final TipoAutomovilDAO objTipoLibroDAO;
    private final Gson objConvertidor;
   
    public Controlador() {
        this.objLibroDAO=new AutomovilDAO();
        this.objAdministradorDAO= new AdministradorDAO();
        this.objTipoLibroDAO= new TipoAutomovilDAO();
        this.objConvertidor= new Gson();
    }
    
    public String atenderPeticion(String JSON) {
        String resultado = "";
        PeticionDTO objPeticion=this.objConvertidor.fromJson(JSON, PeticionDTO.class);
        
        String nombrePeticion=objPeticion.getNombrePetición();       
        switch(nombrePeticion)
        {
            case "RegistrarLibro":
                String JSONArgumento=objPeticion.getArgumentosPetición();
                AutomovilDTO objLibroARegistrar=this.objConvertidor.fromJson(JSONArgumento, AutomovilDTO.class);
                Boolean bandera1=this.objLibroDAO.registrarLibro(objLibroARegistrar);
                resultado=this.objConvertidor.toJson(bandera1);                
            break;
            case "ListarLibros":
                LinkedList<AutomovilDTO> listaLibros= this.objLibroDAO.consultarLibros();
                resultado=this.objConvertidor.toJson(listaLibros);               
            break;
            case "ConsultarSiExisteLibro":
                String codigo1=objPeticion.getArgumentosPetición();
                Boolean bandera2=false;
                if(this.objLibroDAO.consultarLibro(codigo1)!=null)
                {
                    bandera2=true;
                }   
                resultado=this.objConvertidor.toJson(bandera2);   
            break;
            case "EliminarLibro":
                String codigo2=objPeticion.getArgumentosPetición();
                Boolean bandera3=this.objLibroDAO.eliminarLibro(codigo2);
                resultado=this.objConvertidor.toJson(bandera3);  
            break;
            case "ListarTiposDeLibro":                
                LinkedList<TipoAutoDTO> listaTiposLibro= this.objTipoLibroDAO.consultarTiposDeLibros();
                resultado=this.objConvertidor.toJson(listaTiposLibro);  
            break;
            case "IniciarSesion":
                String JSONArgumentoAdministrador=objPeticion.getArgumentosPetición();
                AdministradorDTO objAdministrador=this.objConvertidor.fromJson(JSONArgumentoAdministrador, AdministradorDTO.class);
                Boolean bandera4=this.objAdministradorDAO.consultarAdministrador(objAdministrador);
                resultado=this.objConvertidor.toJson(bandera4);   
            break;
            case "ConsultarEstadisticas":                
                EstadisticaDTO objEstadistica= this.objLibroDAO.consultarEstadisticas();
                resultado=this.objConvertidor.toJson(objEstadistica);  
            break;
            default:
                resultado="Error, petición desconocida";
        }
        
       return resultado;
    }
}
