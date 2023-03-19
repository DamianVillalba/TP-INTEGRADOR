public class Pronostico {
    // TODO Pronostico del participante? hay que construirlo segun el archivo de entrada "pronostico". con puntos o sin puntos? ya que ronda
    //  tiene (ver  los 2 ejemplos de diagrama)
    //propiedades
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    //constructores
    public Pronostico(){

    }
    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado){
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    //get y set

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    //metodos
    /*
    public int puntos(){
    //codigo
        return resultado puntaje  TODO puntosde? acertados por el pronostico?
    }
     */
}
