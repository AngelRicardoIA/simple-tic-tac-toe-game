import java.util.Scanner;

/**
 * Clase Jugador: Encapsula la identidad y el comportamiento
 * de entrada del usuario en el sistema.
 */
public class Player {
    // Atributos privados (Encapsulamiento Duro)
    private String nombre;
    private char simbolo;

    // Constructor: Moldea los datos del objeto al nacer en la RAM
    public Player(String nombre, char simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    // Método Autónomo: Se encarga por completo del flujo de captura
    public int[] elegirCoordenada(Scanner lector) {
        int[] coordenadas = new int[2];
        try {
            System.out.print("Ingresa Fila y Columna separadas por un espacio: ");
            coordenadas[0] = lector.nextInt(); // Fila
            coordenadas[1] = lector.nextInt(); // Columna
        } catch (Exception e) {
            System.out.println("Error: Se detectaron caracteres no numéricos en la entrada.");
            lector.nextLine(); // Limpieza perimetral del buffer del Scanner
            coordenadas[0] = -1; // Forzamos coordenadas inválidas
            coordenadas[1] = -1;
        }
        return coordenadas;
    }

    // Getters públicos para permitir lectura segura de atributos protegidos
    public String getNombre() {
        return this.nombre;
    }

    public char getSimbolo() {
        return this.simbolo;
    }
}