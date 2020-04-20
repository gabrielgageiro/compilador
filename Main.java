import java.awt.EventQueue;

import javax.swing.*;

class Main extends JFrame {

    private JPanel contentPane;
    private JTable tableCodigo;
    private JTable tablePalavra;
    private JTextArea textAreaPrograma = new JTextArea();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal frame = new Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
  }
