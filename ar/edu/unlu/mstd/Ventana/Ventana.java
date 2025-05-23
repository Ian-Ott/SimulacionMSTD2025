package ar.edu.unlu.mstd.Ventana;

import ar.edu.unlu.mstd.Modelo.ModeloMatematico;
import ar.edu.unlu.mstd.Ventana.Panel.JPanelCircular;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JFrame frame;
    private JTextField textCantidadA;
    private JPanel panelPrincipal;
    private JTextArea ingreseLaCantidadDeTextArea;
    private JButton buttonCalcular;
    private JPanel panelCarta;
    private JPanel panel1;
    private JTextArea SIMULACIONMETODODEMONTECARLOTextArea;
    ModeloMatematico modelo;
    CardLayout card = (CardLayout) panelCarta.getLayout();

    public Ventana(){
        frame = new JFrame("Simulacion de arroz");
        frame.setSize(1100, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actual = textCantidadA.getText();
                Integer valor = 0;
                if (actual != null) {
                    try {
                        valor = Integer.parseInt(textCantidadA.getText());
                    } catch (NumberFormatException ex){
                        mostrarError("Los datos ingresados no son validos");
                    }
                    if (valor <= 10000 && valor >= 0) {
                        modelo = new ModeloMatematico(valor);
                        modelo.lanzarArroz();
                        mostrarResultado();
                    }else{
                        mostrarError("El limite es entre 0 y 10000");
                    }
                }else {
                    mostrarError("El campo no puede estar vacio");
                }
            }
        });
    }

    private void mostrarResultado() {
        double total = modelo.getCantEnCirculo() + modelo.getCantEnCuadrado();
        double cantCir = modelo.getCantEnCirculo();
        double cantC = modelo.getCantEnCuadrado();
        JPanel panelResultado = new JPanel();
        TextArea txtR = new TextArea("Los valores resultado son: \n Cantidad de arroz en el cuadrado " + cantC +
                "\n Cantidad de arroz en el Circulo: " + cantCir +
                "\n Porcentaje en el Cuadrado: " + (cantC / total) * 100 + "%" +
                "\n Porcentaje en el Circulo: " + (cantCir / total) * 100 + "%"
                );
        txtR.setPreferredSize(new Dimension(500,500));
        txtR.setBackground(Color.white);
        txtR.setForeground(Color.black);
        txtR.setFont(new Font("Calibri", Font.BOLD, 16));
        panelResultado.add(txtR);
        panelResultado.setBackground(Color.WHITE);
        JFrame frame2 = new JFrame("Simulacion de arroz");
        frame2.setBackground(Color.WHITE);
        frame2.setLayout(new BorderLayout());
        frame2.setSize(1100, 600);
        //frame2.setResizable(false);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelR = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelR.setBackground(Color.WHITE);


        JTextArea txtResult = new JTextArea("RESULTADOS");
        txtResult.setBackground(Color.RED);
        txtResult.setDisabledTextColor(Color.BLACK);
        txtResult.setFont(new Font("Calibri", Font.BOLD, 24));
        txtResult.setBorder(new LineBorder(Color.BLACK));
        txtResult.setEditable(false);
        txtResult.setEnabled(false);
        txtResult.setBorder(new LineBorder(Color.BLACK));
        panelR.add(txtResult);

        JPanel panelGrafico = new JPanel();
        panelGrafico.setBackground(Color.WHITE);
        panelGrafico.setLayout(null);
        panelGrafico.setBounds(0,0,500,500);

        JLabel labelCirculo = new JLabel();
        labelCirculo.setBounds(0,0,500,500);

        JLayeredPane layeredPane1 = new JLayeredPane();
        layeredPane1.setBounds(0,0,500,500);
        layeredPane1.add(labelCirculo,0);
        JPanel panelCuadrado = new JPanel(new BorderLayout());
        panelCuadrado.setBorder(new LineBorder(Color.black));
        panelCuadrado.setBackground(Color.GREEN);
        panelCuadrado.setBounds(50,50,400,400);
        JPanelCircular panelCirculo = new JPanelCircular(500,Color.CYAN);
        panelCirculo.setOpaque(false);
        //panelCirculo.setBackground(Color.CYAN);
        //panelCirculo.setBounds(100,100,300,300);
        panelCirculo.setBounds(50,50,400,400);
        panelCirculo.setLayout(null);

        //panelCirculo.add(panelCuadrado,BorderLayout.CENTER);

        for (int i = 0; i < modelo.getCantEnCirculo(); i++) {
            JLabel labelA = new JLabel("I");
            //labelA.setBounds(0,0,500,500);
            //labelA.setAlignmentX((float) modelo.getProbArrozCirculo(i));
            //labelA.setAlignmentY((float) modelo.getProbArrozCirculo(i));
            //panelCuadrado.add(labelA,BorderLayout.SOUTH);
            panelCirculo.addCirculo(labelA,(int)(modelo.getProbArrozCirculo(i) * 1000000000));
        }
        JLayeredPane layeredPane2 = new JLayeredPane();

        layeredPane2.setBounds(0,0,500,500);
        layeredPane1.add(layeredPane2,1);
        layeredPane2.add(panelCuadrado,1);
        panelCuadrado.setOpaque(true);
        layeredPane2.add(panelCirculo,0);
        for (int i = 0; i < modelo.getCantEnCuadrado(); i++) {
            JLabel labelA = new JLabel("a");

            panelCirculo.addFCirculo(labelA,(int)(modelo.getProbArrozCuadrado(i) * 1000000000));
        }


        panelGrafico.add(layeredPane1);

        frame2.add(panelGrafico,BorderLayout.CENTER);
        frame2.add(panelResultado,BorderLayout.WEST);
        frame2.add(panelR,BorderLayout.NORTH);
        //panelCarta.remove(panelPrincipal);
    }

    private void mostrarError(String textError) {
        JOptionPane.showMessageDialog(null,textError,"ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args){
        new Ventana();
    }
}
