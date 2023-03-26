public class Ronda {
    //propiedades
    private String numeroRonda;
    private Partido[] partidos;

    //constructores
    public Ronda(){

    }
    public Ronda(String numeroRonda, Partido[] partidos){
        this.numeroRonda = numeroRonda;
        this.partidos = partidos;
    }

    //get y set

    public String getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(String numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }

    //metodo
    // AGREGAR PARTIDOS

    public int puntos(Pronostico[] pronosticosJugador){
        int aciertos = 0;
        //Itero sobre los pronosticos para sacar el puntaje individual de cada uno
        for(Pronostico pronosticoActual : pronosticosJugador){
            //Itero sobre los partidos para ver si en algun partido hubo un acierto en el pronostico actual
            for (Partido partidoActual : this.partidos){
                if(pronosticoActual.getPartido() == partidoActual && pronosticoActual.getResultado() == partidoActual.resultado()){
                    aciertos++;
                }
            }
        }
        return aciertos;
    }
}
