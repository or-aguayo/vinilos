import java.util.Scanner;

public class ColeccionVinilosConMenu {

    public static void main(String[] args) {
        String vinilos[][] = new String[100][3];
        ejecutarMenu(vinilos);
    }

    public static void ejecutarMenu(String vinilos[][]){
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, vinilos);
        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú de Colección de Vinilos:");
        System.out.println("1. Agregar vinilo");
        System.out.println("2. Mostrar total de vinilos");
        System.out.println("3. Mostrar espacios disponibles");
        System.out.println("4. Borrar un vinilo");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion() {
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    break;
                } else {
                    System.out.print("Opción inválida. Intente nuevamente: ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }

        return opcion;
    }

    public static String leerCadena(String mensaje) {
        Scanner scanner = crearScanner();
        System.out.print(mensaje);
        String cadena = scanner.nextLine();
        return cadena;
    }

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

    public static void ejecutarOpcion(int opcion, String[][] vinilos) {
        switch (opcion) {
            case 1:
                agregarViniloMenu(vinilos);
                break;
            case 2:
                mostrarTotal(vinilos);
                break;
            case 3:
                mostrarDisponibles(vinilos);
                break;
            case 4:
                borrarViniloMenu(vinilos);
                break;
            case 5:
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void agregarViniloMenu(String vinilos[][]) {
        String artista = leerCadena("Ingrese el nombre del artista: ");
        String disco = leerCadena("Ingrese el nombre del disco: ");
        String año = leerCadena("Ingrese el año de lanzamiento: ");

        vinilos = agregarVinilo(vinilos, artista, disco, año);
        System.out.println("Vinilo agregado exitosamente.");
    }

    public static String[][] agregarVinilo(String vinilos[][], String artista, String disco, String año) {
        for (int i = 0; i < vinilos.length; i++) {
            if (vinilos[i][0] == null) {
                vinilos[i][0] = artista;
                vinilos[i][1] = disco;
                vinilos[i][2] = año;
                break;
            }
        }
        return vinilos;
    }

    public static void borrarViniloMenu(String vinilos[][]) {
        String artista = leerCadena("Ingrese el nombre del artista del vinilo a borrar: ");
        String disco = leerCadena("Ingrese el nombre del disco del vinilo a borrar: ");

        if (borrarVinilo(vinilos, artista, disco)) {
            System.out.println("Vinilo borrado exitosamente.");
        } else {
            System.out.println("Vinilo no encontrado en la colección.");
        }
    }

    public static boolean borrarVinilo(String vinilos[][], String artista, String disco) {
        for (int i = 0; i < vinilos.length; i++) {
            if (vinilos[i][0] != null && vinilos[i][0].equals(artista) && vinilos[i][1].equals(disco)) {
                vinilos[i][0] = null;
                vinilos[i][1] = null;
                vinilos[i][2] = null;
                return true;
            }
        }
        return false;
    }

    public static int totalVinilos(String vinilos[][]) {
        int count = 0;
        for (int i = 0; i < vinilos.length; i++) {
            if (vinilos[i][0] != null) {
                count++;
            }
        }
        return count;
    }

    public static void mostrarTotal(String vinilos[][]) {
        System.out.println("Hay un total de: " + totalVinilos(vinilos) + " vinilos en la colección.");
    }

    public static void mostrarDisponibles(String vinilos[][]) {
        System.out.println("Hay un total de: " + (vinilos.length - totalVinilos(vinilos)) + " espacios disponibles en la colección.");
    }
}
