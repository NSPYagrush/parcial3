package servidor.capaAccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import servidor.modelo.dominio.TipoAutoDTO;

public class TipoAutomovilDAO {
    private final ConexionBD conexionABaseDeDatos;
       
    public TipoAutomovilDAO() {
        this.conexionABaseDeDatos = new ConexionBD();
    } 
    
    public LinkedList<TipoAutoDTO> consultarTiposDeAutomovil() {
        System.out.println("Invocando a listar tipos de autos del lado del servidor");
        LinkedList<TipoAutoDTO> tiposDeAutos = new LinkedList();
        conexionABaseDeDatos.conectar(); 
        
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select * from tiposDeAutos";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            ResultSet res = sentencia.executeQuery();
            
            while(res.next())
            {
                TipoAutoDTO objTipo = new TipoAutoDTO();
                objTipo.setIdTipo(res.getInt("idTipo"));
                objTipo.setNombre(res.getString("nombre"));
                tiposDeAutos.add(objTipo);
            }
            
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("error al listar los tipos de libro: " + e.getMessage());         
        }
        
        return tiposDeAutos;
    }
}
