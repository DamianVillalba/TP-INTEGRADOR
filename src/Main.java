import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        List<String> pronostico = infoPronostico(args[0]);
        for (String indice : pronostico){
            System.out.println(indice);
        }
    }

    private static List<String> infoPronostico(String archivoPronostico) throws IOException {
        //sacamos una lista con la informacion del pronostico
        List<String> informacion = null;
        for (String linea : Files.readAllLines(Paths.get(archivoPronostico))){
            informacion = new ArrayList<>(List.of(linea.split(";")));
            break;
        }
        return informacion;
    }
}