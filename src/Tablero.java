/**
 * Clase Tablero: Adueña y protege la matriz del juego.
 * Implementa las reglas físicas y el réferi matemático.
 */
public class Tablero {
    // La matriz queda blindada contra manipulaciones externas
    private char[][] matriz;

    // Constructor: Inicializa el estado base del tablero limpio
    public Tablero() {
        matriz = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = '-';
            }
        }
    }

    // Método: Renderizador oficial del lienzo en la consola
    public void imprimir() {
        System.out.println("\n--- TABLERO ACTUAL ---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }

    // Método: Filtro de integridad perimetral
    public boolean validarMovimiento(int f, int c) {
        if (f < 0 || f > 2 || c < 0 || c > 2) {
            System.out.println("Coordenadas fuera de rango (0-2). Intenta de nuevo.");
            return false;
        }
        if (matriz[f][c] != '-') {
            System.out.println("Casilla ya ocupada. Elige otra posición.");
            return false;
        }
        return true;
    }

    // Método: Registra físicamente la jugada una vez aprobada
    public void registrarTiro(int f, int c, char simbolo) {
        matriz[f][c] = simbolo;
    }

    // Método: Escaneo matricial de las 8 formas de ganar
    public boolean verificarGanador(char j) {
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0] == j && matriz[i][1] == j && matriz[i][2] == j) return true; // Filas
            if (matriz[0][i] == j && matriz[1][i] == j && matriz[2][i] == j) return true; // Columnas
        }
        if (matriz[0][0] == j && matriz[1][1] == j && matriz[2][2] == j) return true; // Diagonal 1
        if (matriz[0][2] == j && matriz[1][1] == j && matriz[2][0] == j) return true; // Diagonal 2
        return false;
    }
}