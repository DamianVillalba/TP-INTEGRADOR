import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        //armado de instancias
        List<String> datosPartido1 = infoArchivo(args[1], 1);
        List<String> datosPartido2 = infoArchivo(args[1], 2);
        Equipo equipo1 = new Equipo(datosPartido1.get(0));
        Equipo equipo2 = new Equipo(datosPartido1.get(3));
        Equipo equipo3 = new Equipo(datosPartido2.get(0));
        Equipo equipo4 = new Equipo(datosPartido2.get(3));
        int golesEquipo1 = Integer.parseInt(datosPartido1.get(1));
        int golesEquipo2 = Integer.parseInt(datosPartido1.get(2));
        int golesEquipo3 = Integer.parseInt(datosPartido2.get(1));
        int golesEquipo4 = Integer.parseInt(datosPartido2.get(2));
        Partido partido1 = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);
        Partido partido2 = new Partido(equipo3, equipo4, golesEquipo3, golesEquipo4);
        Pronostico pronostico1 = new Pronostico(partido1, resultadoPronostico(infoArchivo(args[0], 1)));
        Pronostico pronostico2 = new Pronostico(partido2, resultadoPronostico(infoArchivo(args[0], 2)));
        Pronostico[] pronosticos = new Pronostico[]{pronostico1, pronostico2};
        Partido[] partidos = new Partido[]{partido1, partido2};
        Ronda ronda1 = new Ronda("1", partidos);
        //resultado
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
}