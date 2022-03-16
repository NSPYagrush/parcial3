package servidor.capaAccesoDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import servidor.modelo.dominio.EstadisticaDTO;
import servidor.modelo.dominio.AutomovilDTO;
import servidor.modelo.dominio.TipoAutoDTO;

//la clase permite registrar, eliminar, actualizar, consultar y listar datos de los libros almacenados en el sistema

public class AutomovilDAO {
    private final ConexionBD conexionABaseDeDatos;
    
    public AutomovilDAO() {
        this.conexionABaseDeDatos = new ConexionBD();
    }    

    public boolean registrarLibro(AutomovilDTO objAutomovil) {        
        System.out.println("Invocando a registrar automovil del lado del servidor");
        int resultado = -1;
        conexionABaseDeDatos.conectar();
        
        try {            
            PreparedStatement sentencia = null;
            String consulta = "insert into vehiculos(placa, marca, linea, "
                    + "tipoCarroceria, tipoCombustible, color, descripcion, "
                    + " idTipo, estado, modelo, valor, numeroPuertas, kilometraje, "
                    + "idConcecionario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
             
            sentencia.setString(1, objAutomovil.getPlaca());
            sentencia.setString(2, objAutomovil.getMarca());          
            sentencia.setString(3, objAutomovil.getLinea());          
            sentencia.setString(4, objAutomovil.getTipoCarroceria());          
            sentencia.setString(5, objAutomovil.getTipoCombustible());          
            sentencia.setString(6, objAutomovil.getColor());          
            sentencia.setString(7, objAutomovil.getDescripcion());
            sentencia.setBoolean(8, objAutomovil.isEstado());
            sentencia.setFloat(9, objAutomovil.getModelo());
            sentencia.setFloat(10, objAutomovil.getValor());
            sentencia.setInt(11, objAutomovil.getNumeroPuertas());
            sentencia.setInt(12, objAutomovil.getKilometraje());
            sentencia.setInt(13, objAutomovil.getObjTipoAuto().getIdTipo());
            sentencia.setInt(14, 1);
            
            resultado = sentencia.executeUpdate(); //ejecuto la sentencia contra la base de datos
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la inserción: " + e.getMessage());         
        }
               
        return resultado == 1;
    }
            
    public LinkedList<AutomovilDTO> consultarListaAutos() {
        System.out.println("Invocando a consultar autos del lado del servidor");
        LinkedList<AutomovilDTO> autos = new LinkedList();
        conexionABaseDeDatos.conectar();        
        
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select * from vehiculos inner join tiposDeAutos on vehiculos.idTipo=tiposDeAutos.idTipo";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            ResultSet res = sentencia.executeQuery();
            
            while(res.next()){
                AutomovilDTO objAuto = new AutomovilDTO();
                TipoAutoDTO objTipoAuto = new TipoAutoDTO();
                
                objAuto.setPlaca(res.getString("placa"));
                objAuto.setMarca(res.getString("marca"));
                objAuto.setLinea(res.getString("linea"));
                objAuto.setTipoCarroceria(res.getString("tipoCarroceria"));
                objAuto.setTipoCombustible(res.getString("tipoCombustible"));
                objAuto.setColor(res.getString("color"));
                objAuto.setDescripcion(res.getString("descripcion"));
                objAuto.setEstado(res.getBoolean("estado"));
                objAuto.setModelo(res.getFloat("modelo"));
                objAuto.setValor(res.getFloat("valor"));
                objAuto.setNumeroPuertas(res.getInt("numeroPuertas"));
                objAuto.setKilometraje(res.getInt("kilometraje"));
                objTipoAuto.setIdTipo(res.getInt("idTipo"));
                objTipoAuto.setNombre(res.getString("tiposDeAutos.nombre"));
                objAuto.setObjTipoAuto(objTipoAuto);
                
                autos.add(objAuto);
            }
            
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la consulta de los autos: " + e.getMessage());         
        }
        
        return autos;
    }
            
    public AutomovilDTO consultarAuto(String placa) {
        System.out.println("Invocando a consultar auto por placa del lado del servidor");
        AutomovilDTO objAuto = null;
        conexionABaseDeDatos.conectar();        
        
        try {            
            PreparedStatement sentencia = null;
            String consulta = "select * from vehiculos inner join tiposDeAutos on vehiculos.idTipo=tiposDeAutos.idTipo where codigo=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, placa);
            ResultSet res = sentencia.executeQuery();
            
            if(res.next()){
                objAuto = new AutomovilDTO();
                TipoAutoDTO objTipoAuto = new TipoAutoDTO();
                
                objAuto.setPlaca(res.getString("placa"));
                objAuto.setMarca(res.getString("marca"));
                objAuto.setLinea(res.getString("linea"));
                objAuto.setTipoCarroceria(res.getString("tipoCarroceria"));
                objAuto.setTipoCombustible(res.getString("tipoCombustible"));
                objAuto.setColor(res.getString("color"));
                objAuto.setDescripcion(res.getString("descripcion"));
                objAuto.setEstado(res.getBoolean("estado"));
                objAuto.setModelo(res.getFloat("modelo"));
                objAuto.setValor(res.getFloat("valor"));
                objAuto.setNumeroPuertas(res.getInt("numeroPuertas"));
                objAuto.setKilometraje(res.getInt("kilometraje"));
                objTipoAuto.setIdTipo(res.getInt("idTipo"));
                objTipoAuto.setNombre(res.getString("tiposDeAutos.nombre"));
                objAuto.setObjTipoAuto(objTipoAuto);
            }
            
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la consulta de un automovil: " + e.getMessage());         
        }
        
        return objAuto;
    }
    
    public boolean actualizarLibro(AutomovilDTO objAuto, String codigo) {        
        System.out.println("Invocando a actualizar libro del lado del servidor");
        conexionABaseDeDatos.conectar();
        int resultado = -1;
        //matenme ya pofa
        try {            
            PreparedStatement sentencia = null;
            String consulta = "update libros set libros.codigo=?,"
                                                 + "libros.titulo=?,"
                                                 + "libros.cantidad=? "
                                                 + "libros.idTipo=?"
                                                 + "where libros.codigo=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);
            sentencia.setString(1, objAuto.getCodigo());
            sentencia.setString(2, objAuto.getTitulo());
            sentencia.setInt(3, objAuto.getCantidad());
            sentencia.setInt(4, objAuto.getObjTipoLibro().getIdTipo());
            sentencia.setString(5, codigo);
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
            System.out.println("Error en la actualización: " + e.getMessage());         
        }
        
        return resultado == 1;
    }
        
    public boolean eliminarLibro(String codigo) {
        System.out.println("invocando a eliminar libro del lado del servidor");
        conexionABaseDeDatos.conectar();
        int resultado=-1;
        try {            
            PreparedStatement sentencia = null;
            String consulta = "delete from libros where codigo=?";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta);            
            sentencia.setString(1, codigo);
            resultado = sentencia.executeUpdate(); 
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la eliminación: "+e.getMessage());         
        }
        
        return resultado == 1;
    }
    
    public EstadisticaDTO consultarEstadisticas()
    {
        System.out.println("invocando a consultar estadisticas del lado del servidor");
        EstadisticaDTO objEstadisticas=null;
        conexionABaseDeDatos.conectar();        
        
        try {            
            PreparedStatement sentencia = null;
            String consulta1 = "SELECT SUM(codigo) as suma, AVG(codigo) as promedio from libros";
            sentencia = conexionABaseDeDatos.getConnection().prepareStatement(consulta1);            
            ResultSet res = sentencia.executeQuery();
            
            if(res.next()){
                objEstadisticas = new EstadisticaDTO();
                objEstadisticas.setSumaCodigosLibro(res.getFloat("suma"));
                objEstadisticas.setPromedioCodigosLibro(res.getFloat("promedio"));
            }
            sentencia.close();
            conexionABaseDeDatos.desconectar();

        } catch (SQLException e) {
                  System.out.println("error en la consulta de un libro: "+e.getMessage());         
        }
        
        return objEstadisticas;
    }
}
