import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.println("¡BIENVENIDOS AL GATO!");

        Tablero tablero = new Tablero();
        Player j1 = new Player("Jugador 1", 'X');
        Player j2 = new Player("Jugador 2", 'O');

        Player jugadorActual = j1;
        int movimientos = 0;
        boolean juegoActivo = true;

        // Bucle Principal del Juego (Game Loop)
        while (juegoActivo) {
            tablero.imprimir();
            System.out.println("Turno de: " + jugadorActual.getNombre() + " (" + jugadorActual.getSimbolo() + ")");

            // Le pedimos la coordenada al objeto Jugador
            int[] coord = jugadorActual.elegirCoordenada(lector);

            // Le pedimos al Tablero que verifique si el tiro es válido
            if (!tablero.validarMovimiento(coord[0], coord[1])) {
                continue; // Reinicia el turno si falla la validación
            }

            // Registramos la ficha en el tablero
            tablero.registrarTiro(coord[0], coord[1], jugadorActual.getSimbolo());
            movimientos++;

            // Evaluación de estados de salida
            if (tablero.verificarGanador(jugadorActual.getSimbolo())) {
                tablero.imprimir();
                System.out.println("¡BRUTAL! Ha ganado: " + jugadorActual.getNombre() + " 🏆");
                juegoActivo = false;
            } else if (movimientos == 9) {
                tablero.imprimir();
                System.out.println("¡Es un empate técnico en la matriz!");
                juegoActivo = false;
            } else {
                // Alternación elegante de punteros usando operador ternario
                jugadorActual = (jugadorActual == j1) ? j2 : j1;
            }
        }

        System.out.println("\n  Fin de la sesión. ¡Gracias por jugar, Ingenieros!");
        lector.close();
    }
}