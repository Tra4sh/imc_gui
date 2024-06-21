package view;

import model.Imc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TelaImc {

    private JPanel painelTitulo = new JPanel();
    private JLabel labelTitulo = new JLabel("Indice de massa corporal - IMC");
    private JLabel imcPeso = new JLabel("peso:");
    private JTextField txtPeso = new JFormattedTextField();
    private JLabel imcAltura = new JLabel("Altura:");
    private JTextField txtAltura = new JFormattedTextField();
    private JLabel imcTituloResultadoImc = new JLabel("Resultado do IMC");
    private JLabel imcResultadoImc = new JLabel("25,00");
    private JLabel imcStatusImc = new JLabel("Normal");
    private JButton botaoCalcular = new JButton("Calcular");
    private JButton botaoLimpar = new JButton("Limpar");

    private String imagePacht = "../imagens/";
   // private Icon iconBtnCalcular = new ImageIcon(getClass().getResource(imagePacht + "calc2.png"));
    //private Icon iconBtnLimpar = new ImageIcon(getClass().getResource(imagePacht + "restart24.png"));

    //private Icon iconBtnCalcular = new ImageIcon(getClass().getResource(imagePacht + "calc2.png"));
  //  private Icon iconBtnLimpar = new ImageIcon(getClass().getResource(imagePacht + "restart24.png"));

    private Imc imc = new Imc();

    int peso = 0;
    double altura = 0.0;

    public TelaImc(){
        CriarTela();
    }
    public void CriarTela(){
        JFrame frame = new JFrame();
        Random gerador = new Random();



        frame.setTitle("Calculadora IMC");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        painelTitulo.setBounds(0,0,500,50);

        frame.getContentPane().add(painelTitulo);
        painelTitulo.setLayout(null);
        labelTitulo.setBounds(10,10,200,30);
        painelTitulo.add(labelTitulo);
        frame.getContentPane().add(painelTitulo);

        imcPeso.setBounds(10,70,150, 30);
        txtPeso.setBounds(10,100,150,35);
        txtPeso.setFont(new Font("Arial", Font.BOLD, 24));

        imcAltura.setBounds(10,140,150,30);
        txtAltura.setBounds(10,170,150,35);
        txtAltura.setFont(new Font("Arial", Font.BOLD, 24));

        imcTituloResultadoImc.setBounds(260,70,250,30);
        imcTituloResultadoImc.setForeground(Color.blue);
        imcTituloResultadoImc.setFont(new Font("Arial", Font.BOLD, 20));
        imcTituloResultadoImc.setHorizontalAlignment(JLabel.CENTER);

        imcResultadoImc.setBounds(260,120,250,30);
        imcResultadoImc.setFont(new Font("Arial", Font.BOLD, 30));
        imcResultadoImc.setForeground(Color.red);
        imcResultadoImc.setHorizontalAlignment(JLabel.CENTER);

        imcStatusImc.setBounds(260,150,250,30);
        imcStatusImc.setFont(new Font("Arial", Font.BOLD, 20));
        imcStatusImc.setHorizontalAlignment(JLabel.CENTER);

        botaoCalcular.setBounds(10, 220,120,30);
        //botaoCalcular.setIcon(iconBtnCalcular);
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalcularImc();
            }
        });

        botaoLimpar.setBounds(110,220, 120,30);
        //botaoLimpar.setIcon(iconBtnLimpar);
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LimparTela();
            }
        });

        frame.getContentPane().add(painelTitulo);
        frame.getContentPane().add(imcPeso);
        frame.getContentPane().add(txtPeso);
        frame.getContentPane().add(imcAltura);
        frame.getContentPane().add(txtAltura);
        frame.getContentPane().add(imcTituloResultadoImc);
        frame.getContentPane().add(imcResultadoImc);
        frame.getContentPane().add(imcStatusImc);
        frame.getContentPane().add(botaoCalcular);
        frame.getContentPane().add(botaoLimpar);

        frame.setVisible(true);

        while(true){
            painelTitulo.setBackground(new Color(gerador.nextInt()));
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
            }
        }
    }

    private void LimparTela(){
     txtAltura.setText("");
     txtPeso.setText("");
     imcStatusImc.setText("");
     imcResultadoImc.setText("");
     txtPeso.requestFocus();
    }
    private void CalcularImc(){
        if(validarDados()){

            imc.setImc(peso);
            imc.setAltura(altura);

            if(imc.getImc() <= 18.5 || imc.getImc() <= 25.0){
                imcResultadoImc.setForeground(Color.GREEN);
            }else{
                imcResultadoImc.setForeground(Color.RED);
            }
            imcStatusImc.setText(imc.getStatus());
            String resultImc = String.valueOf(imc.getImc());
//            imcResultadoImc.setText(
//                    String.format("%,2f",resultImc.trim().replace(".",","))
//            );
            imcResultadoImc.setText(resultImc);

        }else {
        }
    }
    private boolean validarDados(){
        try{
            peso = Integer.parseInt(txtPeso.getText().trim());

        }catch (NumberFormatException erro){
            System.out.println(erro);
            JOptionPane.showMessageDialog(
                    null,
                    "O peso deve ser um valor numerico !!!!",
                    "Valor invalido",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        try{
            altura = Double.parseDouble(txtAltura.getText().replace(",",".").trim());
        }catch (NumberFormatException erro){
            System.out.println(erro);
            JOptionPane.showMessageDialog(
                    null,
                    "O altura deve ser um valor numerico !!!!",
                    "Valor invalido",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }
}


