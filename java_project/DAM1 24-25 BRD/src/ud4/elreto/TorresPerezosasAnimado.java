package ud4.elreto;

import javax.swing.*;
import java.awt.*;

public class TorresPerezosasAnimado extends JPanel {
    private final char[][] tablero;
    private final int[][] dp;
    private static final int TILE_SIZE = 50; // Tamaño de cada celda
    private int pasoActual = 0; // Controla la animación
    private final int filas, columnas;

    public TorresPerezosasAnimado(char[][] tablero) {
        this.tablero = tablero;
        this.filas = tablero.length;
        this.columnas = tablero[0].length;
        this.dp = new int[filas][columnas];

        // Iniciar animación en un hilo separado
        new Thread(this::calcularCaminos).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == 'X') {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(Color.GRAY);
                g.drawRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                if (dp[i][j] > 0) {
                    g.setColor(Color.RED);
                    g.drawString(String.valueOf(dp[i][j]), j * TILE_SIZE + 20, i * TILE_SIZE + 30);
                }
            }
        }
    }

    private void calcularCaminos() {
        if (tablero[0][0] == 'X') return;

        dp[0][0] = 1;
        repaint();
        esperar();

        for (int i = 1; i < filas; i++) {
            if (tablero[i][0] != 'X') {
                dp[i][0] = dp[i - 1][0];
                repaint();
                esperar();
            }
        }

        for (int j = 1; j < columnas; j++) {
            if (tablero[0][j] != 'X') {
                dp[0][j] = dp[0][j - 1];
                repaint();
                esperar();
            }
        }

        for (int i = 1; i < filas; i++) {
            for (int j = 1; j < columnas; j++) {
                if (tablero[i][j] != 'X') {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    repaint();
                    esperar();
                }
            }
        }
    }

    private void esperar() {
        try {
            Thread.sleep(500); // Esperar 500ms para cada actualización
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        char[][] tablero = {
                {'.', '.', '.'},
                {'X', 'X', '.'},
                {'.', '.', '.'}
        };
        char[][] tablero2 = {
                {'.', '.', '.'},
                {'.', '.', 'X'},
                {'.', '.', '.'}
        };
        char[][] tablero3 = {
                {'.', '.', '.'},
                {'X', '.', 'X'},
                {'.', '.', '.'}
        };
        char[][] tablero4 = {
                {'.', 'X', '.'},
                {'.', '.', '.'},
                {'.', 'X', '.'}
        };

        // Crear y posicionar las ventanas correctamente
        crearVentana(new TorresPerezosasAnimado(tablero), "Torres Perezosas 1", 0, 0);
        crearVentana(new TorresPerezosasAnimado(tablero2), "Torres Perezosas 2", 0, 250);
        crearVentana(new TorresPerezosasAnimado(tablero3), "Torres Perezosas 3", 250, 0);
        crearVentana(new TorresPerezosasAnimado(tablero4), "Torres Perezosas 4", 250, 250);
    }

    private static void crearVentana(TorresPerezosasAnimado panel, String titulo, int x, int y) {
        JFrame frame = new JFrame(titulo);
        frame.add(panel);
        frame.setSize(250, 250);
        frame.setLocation(x, y); // Posiciona correctamente la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

