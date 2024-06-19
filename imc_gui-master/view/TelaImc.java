package view;
import model.Imc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaImc {

    private JPanel painelTitulo = new JPanel();
    private JLabel labelTitulo = new JLabel("Índice de Massa Corporal - IMC");
    private JLabel lblPeso = new JLabel("Peso:");
    private JTextField txtPeso = new JTextField();
    private JLabel lblTituloResultadoImc = new JLabel("Resultado do IMC:");
    private JLabel lblResultadoImc = new JLabel("");
    private JLabel lblStatusImc = new JLabel("Normal");

    private JButton btnCalcular = new JButton();
    private JButton btnLimpar = new JButton();

    private JLabel lblALtura = new JLabel("Altura:");
    private JTextField txtAltura = new JTextField();

    private String imagePath = "../images/";
    private Icon iconCalcular = new ImageIcon(getClass().getResource(imagePath + "calc2.png"));
    private Icon iconBtnLimpar = new ImageIcon(getClass().getResource(imagePath + "restart24.png"));

    Imc imc = new Imc();

    public TelaImc(){criarTela();}

    public void criarTela(){
        JFrame tela = new JFrame();
        tela.setSize(500,300);
        tela.setTitle("Calculo de IMC");
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLayout(null);


//        DEFINIR O PAINEL DE TITULO
        painelTitulo.setBounds(0,0,500,50);
        painelTitulo.setBackground(new Color(255, 175, 221));
        labelTitulo.setBounds(10,10,500,30);

        labelTitulo.setFont(new Font("Arial",Font.BOLD,24));
        labelTitulo.setForeground(Color.BLACK);

//        COMPONENTES  TELA
        lblPeso.setBounds(10,70,150,30);
        txtPeso.setBounds(10,100,150,35);
        txtPeso.setFont(new Font("Arial",Font.BOLD,24));

        lblALtura.setBounds(10,140,150,30);
        txtAltura.setBounds(10,170,150,35);
        txtAltura.setFont(new Font("Arial",Font.BOLD,24));

        lblTituloResultadoImc.setBounds(225,70,250,30);
        lblTituloResultadoImc.setForeground(Color.BLACK);
        lblTituloResultadoImc.setFont(new Font("Arial",Font.BOLD,24));
        lblTituloResultadoImc.setHorizontalAlignment(JLabel.CENTER);

        lblResultadoImc.setBounds(225,110,250,30);
        lblResultadoImc.setFont(new Font("Arial",Font.BOLD,38));
        lblResultadoImc.setForeground(Color.BLACK);
        lblResultadoImc.setHorizontalAlignment(JLabel.CENTER);

        lblStatusImc.setBounds(225,150,250,30);
        lblStatusImc.setFont(new Font("Arial",Font.BOLD,24));
        lblStatusImc.setForeground(Color.BLACK);
        lblStatusImc.setHorizontalAlignment(JLabel.CENTER);

        btnCalcular.setBounds(190,220,130,30);
        btnCalcular.setIcon(iconCalcular);
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularImc();
            }
        });

        btnLimpar.setBounds(330,220,130,30);
        btnLimpar.setIcon(iconBtnLimpar);
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparTela();
            }
        });

        tela.getContentPane().add(labelTitulo);
        tela.getContentPane().add(painelTitulo);
        tela.getContentPane().add(lblPeso);
        tela.getContentPane().add(txtPeso);
        tela.getContentPane().add(lblALtura);
        tela.getContentPane().add(txtAltura);
        tela.getContentPane().add(lblTituloResultadoImc);
        tela.getContentPane().add(lblResultadoImc);
        tela.getContentPane().add(lblStatusImc);
        tela.getContentPane().add(btnCalcular);
        tela.getContentPane().add(btnLimpar);

        tela.setVisible(true);
    }
    private void limparTela(){
        txtAltura.setText("");
        txtPeso.setText("");
        lblStatusImc.setText("");
        lblResultadoImc.setText("");
        txtPeso.requestFocus();
    }
    private void calcularImc(){
        lblStatusImc.setText(imc.getStatus());
        lblResultadoImc.setText(imc.get);
    }
}
