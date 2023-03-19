public class Ronda {
    // TODO tira la ronda (ej: 4), los partidos de esa ronda (ej: Real vs Barca y Boca vs River) y va anotando los puntos acertados del pronostico?
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
}
