import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;
import java.util.Scanner;

public class generadorMetodo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        @SuppressWarnings("resource")
        Scanner so = new Scanner(System.in);
        Integer sistemaOperativo = null;
        Integer tipoSo = null;
        Utilitarios utilitarios = new Utilitarios();

        Boolean isLinux = true;
        while (isLinux) {

            System.out.println("Ingrese 0 = Si es Linux");
            System.out.println("Ingrese 1 = Para Windows");
            sistemaOperativo = so.nextInt();

            tipoSo = utilitarios.valida0o1(sistemaOperativo);

            if ((tipoSo == 0) || (tipoSo == 1)) {
                isLinux = false;
            } else {
                isLinux = true;
            }
        }

        if (tipoSo == 0) {
            System.out.println("Si ejecuta desde Linux, no se necesita ninguna configuración, disfrute!!!");
        } else {
            System.out.println(
                    "Si ejecuta desde Windows, debe colocar el archivo 'config.properties' en la raiz c: de windows");
        }

        @SuppressWarnings("resource")
        Scanner tipoConsulta = new Scanner(System.in);
        Integer tipoSeleccion = null;
        Integer seleccionQuery = null;
        Boolean tipoQuery = true;
        while (tipoQuery) {

            System.out.println("Ingrese 0 = Si es una consulta");
            System.out.println("Ingrese 1 = Es un query de creación, modificación o eliminación");
            tipoSeleccion = tipoConsulta.nextInt();

            seleccionQuery = utilitarios.valida0o1(tipoSeleccion);

            if ((seleccionQuery == 0) || (seleccionQuery == 1)) {
                tipoQuery = false;
            } else {
                tipoQuery = true;
            }
        }

        Properties config = new Properties();
        InputStream configInput = null;

        if (tipoSo == 0) {
            configInput = new FileInputStream("resources/config.properties");
        } else {
            configInput = new FileInputStream("C:\\config.properties");
        }

        config.load(configInput);

        String schema = config.getProperty("schema");

        String nombreDirectorioPrincipal = "MetodoGenerado";
        String nombreDirectorioRepositorio = "Repositorio";

        GeneraDirectorioPrincipal generaDirectorioPrincipal = new GeneraDirectorioPrincipal();
        generaDirectorioPrincipal.generaDirectorioPrincipal(nombreDirectorioPrincipal);

        GeneraDirectorioRepository generaDirectorioRepository = new GeneraDirectorioRepository();
        generaDirectorioRepository.generaDirectorioRepository(nombreDirectorioPrincipal, nombreDirectorioRepositorio,
                seleccionQuery);

    }

}
