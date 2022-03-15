package servidor.vista;

import java.io.IOException;
import servidor.servicios.Controlador;
import servidor.servicios.Servidor;

public class vistaPrincipalServidor {

    public static void main(String[] args) {
        try { 
            Controlador objControlador = new Controlador();
            Servidor objServidor= new Servidor(5000, objControlador);
            objServidor.ejecutarServidor();
        } catch (IOException ex) {
            System.out.println("Error al ejecutar el servidor");
        }
        
    }  
}
