import analises.AnaliseLexica;
import analises.AnaliseSintatica;
import automato.Token;
import exceptions.AnaliseLexicaException;
import exceptions.AnaliseSintaticaException;
import utils.TokenTableModel;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.util.Stack;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;

class Principal extends JFrame {

    private JTextArea textAreaPrograma = new JTextArea();
    private JTable tabelaCodigo;
    private JTable tabelaCodigoSemantico;
    JTextArea txtConsole = new JTextArea();

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
        setBounds(100, 100, 905, 791);

        JButton btnSalvar = new JButton();
        btnSalvar.setIcon(new ImageIcon(Principal.class.getResource("/img/salvar.png")));
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("SALVEI");
            }
        });

        JButton btnAbrir = new JButton();
        btnAbrir.setIcon(new ImageIcon(Principal.class.getResource("/img/abrir.png")));
        btnAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int returnValue = jfc.showOpenDialog(null);

                    System.out.println("ABRI");
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File arquivo = jfc.getSelectedFile();
                        BufferedReader ler = new BufferedReader(new FileReader(arquivo));
                        System.out.println(ler);
                    }
                } catch (IOException e1) {
//                     TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        JButton btnEditar = new JButton();
        btnEditar.setIcon(new

                ImageIcon(Principal.class.getResource("/img/editar.png")));
        btnEditar.addActionListener(new

                                            ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    reset();
                                                }
                                            });

        JButton btnRodar = new JButton();
        btnRodar.setIcon(new
                ImageIcon(Principal.class.getResource("/img/rodar.png")));
        btnRodar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textAreaPrograma.getText());
                if (textAreaPrograma != null && !textAreaPrograma.getText().isEmpty()) {
                    try {
                        System.out.println("OI");
                        Stack<Token> tokensSet = AnaliseLexica.analisar(textAreaPrograma.getText().toCharArray());
                        if (tokensSet != null && !tokensSet.isEmpty()) {
                            Stack<Token> linhas = (Stack<Token>) tokensSet.clone();
                            tabelaCodigo.setModel(new TokenTableModel(linhas));
                            txtConsole.append("Analise Lexica terminado com sucesso!\n");

                            Stack<Token> pilhaParsingInicial = AnaliseSintatica.getPilhaParsingInicial();
                            while (!tokensSet.isEmpty() || !pilhaParsingInicial.isEmpty()) {
                                AnaliseSintatica.analisar(tokensSet, pilhaParsingInicial);
                                txtConsole.append("Analise Sintatica terminado com sucesso!\n");
                            }
                        }
                    } catch (AnaliseLexicaException e1) {
                        System.err.println(e1.getMessage());
                        txtConsole.append(e1.getMessage());
                    } catch (AnaliseSintaticaException e2) {
                        txtConsole.append(e2.getMessage());
                    }
                }
            }
        });

        JButton btnParar = new JButton();
        btnParar.setIcon(new

                ImageIcon(Principal.class.getResource("/img/parar.png")));
        btnParar.addActionListener(new

                                           ActionListener() {
                                               public void actionPerformed(ActionEvent e) {
                                                   reset();
                                                   System.out.println("PAREI");
                                               }
                                           });



        JLabel lblConsole = new JLabel("Console");

        JScrollPane scrollPane_2 = new JScrollPane();
        if (txtConsole == null) {
            txtConsole = new JTextArea();
        }
        scrollPane_2.setViewportView(txtConsole);

        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setMaximumSize(new Dimension(32763217, 32321767));

        JTextArea lineCount = new JTextArea();
        lineCount.setText("1");
        lineCount.setForeground(Color.RED);
        lineCount.setEditable(false);
        jScrollPane.setRowHeaderView(lineCount);

        if (textAreaPrograma == null) {
            textAreaPrograma = new JTextArea();
        }

        jScrollPane.setViewportView(textAreaPrograma);

        JScrollPane scrollPane_1 = new JScrollPane();

        tabelaCodigo = new JTable();
        tabelaCodigo.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "C\u00F3digo", "Palavra"
                }
        ));
        tabelaCodigo.setToolTipText("");
        tabelaCodigo.setBorder(null);
        scrollPane_1.setViewportView(tabelaCodigo);

        JScrollPane scrollPane_1_1 = new JScrollPane();

        tabelaCodigoSemantico = new JTable();
        tabelaCodigoSemantico.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "C\u00F3digo", "Palavra"
                }
        ));
        tabelaCodigoSemantico.setToolTipText("");
        tabelaCodigoSemantico.setBorder(null);
        scrollPane_1_1.setViewportView(tabelaCodigoSemantico);
        GroupLayout gl_contentPane = new GroupLayout(getContentPane());
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(5)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(btnAbrir, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(btnRodar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10)
                                                .addComponent(btnParar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                                                .addGap(7)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGap(3)
                                                                .addComponent(scrollPane_1_1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(lblConsole, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 874, Short.MAX_VALUE)))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAbrir, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRodar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnParar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(11)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 582, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 276, Short.MAX_VALUE)
                                                .addGap(11)
                                                .addComponent(scrollPane_1_1, GroupLayout.PREFERRED_SIZE, 291, Short.MAX_VALUE)))
                                .addComponent(lblConsole)
                                .addGap(4)
                                .addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
        );
        getContentPane().setLayout(gl_contentPane);
    }

    private void reset() {
//        derivacoes = null;
//        parsing = null;

        tabelaCodigo.setModel(new TokenTableModel(new Stack<>()));
        tabelaCodigoSemantico.setModel(new TokenTableModel(new Stack<>()));

        txtConsole.setText("");
    }
}
