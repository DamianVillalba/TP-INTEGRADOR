import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        //armado de instancias
        List<Pronostico> pronosticos = new ArrayList<>();
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Partido partido = new Partido();
        Pronostico pronostico = new Pronostico();
        List<Partido> partidos = new ArrayList<>();
        for(int indice = 1; indice <= cantidadPartidos(args[0]); indice++){
            List<String> datosPartido = infoArchivo(args[1], indice);
            equipo1.setNombre(datosPartido.get(0));
            equipo2.setNombre(datosPartido.get(3));
            int golesEquipo1 = Integer.parseInt(datosPartido.get(1));
            int golesEquipo2 = Integer.parseInt(datosPartido.get(2));
            partido.setEquipo1(equipo1);
            partido.setEquipo2(equipo2);
            partido.setGolesEquipo1(golesEquipo1);
            partido.setGolesEquipo2(golesEquipo2);
            pronostico.setPartido(partido);
            pronostico.setResultado(resultadoPronostico(infoArchivo(args[0], indice)));
            pronosticos.add(pronostico);
            System.out.println(pronostico.getPartido().getEquipo1().getNombre()); //SALE ARGENTINA PRIMERO Y SEGUNDO POLONIA
            partidos.add(partido);
        }
        Ronda ronda1 = new Ronda("1", partidos);
        //resultado
        System.out.println("--------------");
        System.out.println(pronosticos.get(0).getPartido().getEquipo1().getNombre()); //SALE SOLO POLONIA A PESAR DE QUE SALE ARGENTINA EN LA PRIMERA VUELTA
        System.out.println("--------------");
        for(Pronostico pronostico1 : pronosticos){
            System.out.println(pronostico1.getPartido().getEquipo1().getNombre());
            System.out.println(pronostico1.getResultado());
        }

        System.out.println("Puntaje del pronostico: " + ronda1.puntos(pronosticos));
    }

    private static List<String> infoArchivo(String archivoResultado, int partido) throws IOException {
        //sacamos una lista con la informacion del partido (al ser univocos no importa cual de los dos archivos procesar para sacar los equipos)
        //el parametro partido indica el numero de partido correspondiente (linea), debe existir ese partido sino da error.
        List<String> informacion = null;
        int partidoActual = 1;
        for (String linea : Files.readAllLines(Paths.get(archivoResultado))){
            if(partido != partidoActual){
                partidoActual++;
                continue;
            }
            informacion = new ArrayList<>(List.of(linea.split(";")));
            break;
        }
        return informacion;
    }

    private static ResultadoEnum resultadoPronostico(List<String> datosPronostico){
        //retornamos el resultado segun el pronostico
        if (datosPronostico.get(1).equals("X")){
            return ResultadoEnum.GANA_EQUIPO1;
        } else if (datosPronostico.get(3).equals("X")) {
            return ResultadoEnum.GANA_EQUIPO2;
        }
        else {
            return ResultadoEnum.EMPATE;
        }
    }

    private static int cantidadPartidos(String archivo) throws IOException{
        int partidos = 0;
        for(String linea : Files.readAllLines(Paths.get(archivo))){
            partidos++;
        }
        return partidos;
    }
}