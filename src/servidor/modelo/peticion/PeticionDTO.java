
package servidor.modelo.peticion;


public class PeticionDTO {
    private String nombrePetición;//registrar cliente, listar clientes, consultar si existe cliente, listar libros, registrar empleado
    private String argumentosPetición;// objCliente, objLibro, objEmpleado

    public PeticionDTO() {
    }

    
    public PeticionDTO(String nombrePetición, String argumentosPetición) {
        this.nombrePetición = nombrePetición;
        this.argumentosPetición = argumentosPetición;
    }

    public String getNombrePetición() {
        return nombrePetición;
    }

    public void setNombrePetición(String nombrePetición) {
        this.nombrePetición = nombrePetición;
    }

    public String getArgumentosPetición() {
        return argumentosPetición;
    }

    public void setArgumentosPetición(String argumentosPetición) {
        this.argumentosPetición = argumentosPetición;
    }

    
    
}
