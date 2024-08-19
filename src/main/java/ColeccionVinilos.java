public class ColeccionVinilos {

    public static void main(String[] args) {
        String vinilos[][] = new String[100][3];

        // Agregar vinilos a la colección
        agregarVinilo(vinilos, "Iron Maiden", "Iron Maiden", "1980");
        agregarVinilo(vinilos, "Iron Maiden", "Killers", "1981");
        agregarVinilo(vinilos, "Iron Maiden", "The number of the beast", "1982");
        agregarVinilo(vinilos, "AC-DC", "Back in black", "1980");
        agregarVinilo(vinilos, "AC-DC", "Highway to Hell", "1979");
        agregarVinilo(vinilos, "AC-DC", "Who made who", "1986");
        agregarVinilo(vinilos, "Judas Priest", "British steel", "1980");
        agregarVinilo(vinilos, "Judas Priest", "Painkiller", "1990");
        agregarVinilo(vinilos, "Judas Priest", "Defenders of the faith", "1984");
        agregarVinilo(vinilos, "Kiss", "Destroyer", "1976");
        System.out.println("Espacio máximo colección: " + vinilos.length);
        mostrarTotal(vinilos);
        mostrarDisponibles(vinilos);

        String artista = "AC-DC";
        System.out.println("Buscar artista: " + artista);
        mostrarBusquedaArtista(vinilos, artista);

        buscarArtista(vinilos, artista);
        mostrarColeccion(vinilos);
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

    public static boolean buscarArtista(String vinilos[][], String artista) {
        for (int i = 0; i < vinilos.length; i++) {
            if (vinilos[i][0] != null && vinilos[i][0].equals(artista)) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarColeccion(String vinilos[][]) {
        for (int i = 0; i < vinilos.length; i++) {
            if (vinilos[i][0] != null) {
                System.out.println("Fila " + (i + 1) + ": " + vinilos[i][0] + " - " + vinilos[i][1] + " - " + vinilos[i][2]);
            }
        }
    }

    public static void mostrarTotal(String vinilos[][]) {
        System.out.println("Hay un total de: " + totalVinilos(vinilos) + " vinilos en la colección.");
    }

    public static void mostrarDisponibles(String vinilos[][]) {
        System.out.println("Hay un total de: " + (vinilos.length - totalVinilos(vinilos)) + " espacios disponibles en la colección.");
    }

    public static int disponibles(String vinilos[][]) {
        return vinilos.length - totalVinilos(vinilos);
    }

    public static void mostrarBusquedaArtista(String vinilos[][], String artista) {
        boolean encontrado = buscarArtista(vinilos, artista);
        if (encontrado) {
            System.out.println("El artista " + artista + " sí está en la colección");
        } else {
            System.out.println("El artista " + artista + " no está en la colección");
        }
    }
}