public class Equipo {
    // TODO Registra a un equipo de la competicion?
    //propiedades
    private String nombre;
    private String descripcion;

    //constructores
    public Equipo(){

    }
    public Equipo(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
