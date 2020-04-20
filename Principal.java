import analises.AnaliseLexica;
import automato.Token;
import exceptions.AnaliseLexicaException;
import utils.TokenTableModel;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.Stack;
import java.awt.GridLayout;

class Principal extends JFrame {

    private JPanel contentPane;
    private JTable tableCodigo;
    private JTextArea textAreaPrograma = new JTextArea();
    JTextArea txtConsole = new JTextArea();
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

    /**
     * Create the frame.
     */
    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(Principal.class.getResource("/img/salvar.png")));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnSalvar.setBounds(94, 0, 32, 32);
        contentPane.add(btnSalvar);

        JButton btnAbrir = new JButton();
        btnAbrir.setIcon(new ImageIcon(Principal.class.getResource("/img/abrir.png")));
        btnAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int returnValue = jfc.showOpenDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File arquivo = jfc.getSelectedFile();
                        BufferedReader ler = new BufferedReader(new FileReader(arquivo));
                    }
                } catch (IOException e1) {
//                     TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });


        btnAbrir.setBounds(52, 0, 32, 32);
        contentPane.add(btnAbrir);

        JButton btnEditar = new JButton();
        btnEditar.setIcon(new

                ImageIcon(Principal.class.getResource("/img/editar.png")));
        btnEditar.addActionListener(new

                                            ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                }
                                            });
        btnEditar.setBounds(10, 0, 32, 32);
        contentPane.add(btnEditar);

        JButton btnRodar = new JButton();
        btnRodar.setIcon(new
                ImageIcon(Principal.class.getResource("/img/rodar.png")));
        btnRodar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textAreaPrograma != null && !textAreaPrograma.getText().isEmpty()) {
                    try {
                        Stack<Token> tokensSet = AnaliseLexica.analisar(textAreaPrograma.getText().toCharArray());
                        if (tokensSet != null && !tokensSet.isEmpty()) {
                            Stack<Token> linhas = (Stack<Token>) tokensSet.clone();
                            tableCodigo.setModel(new TokenTableModel(linhas));
                            txtConsole.append("Analise Lexica terminado com sucesso!\n");
                        }
                    } catch (AnaliseLexicaException e1) {
                        System.err.println(e1.getMessage());
                        txtConsole.append(e1.getMessage());
                    }
                }
            }
        });
        btnRodar.setBounds(136, 0, 32, 32);
        contentPane.add(btnRodar);

        JButton btnParar = new JButton();
        btnParar.setIcon(new

                ImageIcon(Principal.class.getResource("/img/parar.png")));
        btnParar.addActionListener(new

                                           ActionListener() {
                                               public void actionPerformed(ActionEvent e) {
                                               }
                                           });
        btnParar.setBounds(178, 0, 32, 32);
        contentPane.add(btnParar);

        if (textAreaPrograma == null) {
            textAreaPrograma = new JTextArea();
        }
        textAreaPrograma.setRows(100);
        textAreaPrograma.setTabSize(100);
        textAreaPrograma.setLineWrap(true);
        textAreaPrograma.setWrapStyleWord(true);
        textAreaPrograma.setBounds(10, 46, 450, 443);
        contentPane.add(textAreaPrograma);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(492, 279, 382, -204);
        contentPane.add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBounds(470, 46, 404, 443);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        JScrollPane scrollPane_1 = new JScrollPane();
        panel.add(scrollPane_1);

        tableCodigo = new

                JTable();
        scrollPane_1.setViewportView(tableCodigo);
        tableCodigo.setBorder(new

                LineBorder(new Color(0, 0, 0)));
        tableCodigo.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "Código", "Palavra"
                }
        ));
        tableCodigo.setToolTipText("");

        JLabel lblConsole = new JLabel("Console");
        lblConsole.setBounds(10, 494, 46, 14);
        contentPane.add(lblConsole);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 513, 864, 98);
        contentPane.add(scrollPane_2);

        scrollPane_2.setViewportView(txtConsole);
    }
}
