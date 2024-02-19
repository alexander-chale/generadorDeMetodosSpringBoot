import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneraDirectorioRepository {

    public void generaDirectorioRepository(String nombreDirectorioPrincipal, String directorioRepositorio, Integer seleccionQuery) {
        File directorioRepository = new File(nombreDirectorioPrincipal+"/"+directorioRepositorio);
        if (directorioRepository.mkdir()) {
            System.out.println("   Directorio " + directorioRepositorio + "/repository creado satisfactoriamente.");
            try (FileWriter fw = new FileWriter(
                nombreDirectorioPrincipal+"/"+directorioRepositorio + "/Repository.java",
                    true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {

                if (0 == seleccionQuery) {
                    out.println("");

                }

                else {
                    out.println("@Modifying");

                }
            
               
              
/*
                if (0 == tipoId) {
                    System.out.println("      Archivo " + entidadMayusculaInicial
                            + "Repository.java con Id Long creado satisfactoriamente.");
                }

                else {
                    System.out.println("      Archivo " + entidadMayusculaInicial
                            + "Repository.java con Id String creado satisfactoriamente.");

                }
                */

            } catch (IOException e) {
                // exception handling left as an exercise for the reader
            }
        }

    }

}
