package snake;

import javax.swing.JFrame;

public class Snake extends JFrame {

    public Snake() {
        initUI();
    }

    private void initUI() {

        add(new SnakeGame());
        setResizable(false);
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame ex = new Snake();
            ex.setVisible(true);
        });
    }
}
