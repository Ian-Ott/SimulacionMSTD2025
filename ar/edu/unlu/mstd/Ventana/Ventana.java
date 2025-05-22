package ar.edu.unlu.mstd.Ventana;

import ar.edu.unlu.mstd.Modelo.ModeloMatematico;

import javax.swing.*;
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
                modelo = new ModeloMatematico(Integer.parseInt(textCantidadA.getText()));
                modelo.lanzarArroz();
                mostrarResultado();
            }
        });
    }

    private void mostrarResultado() {
        JPanel panelResultado = new JPanel();
        TextArea txtR = new TextArea("Los valores resultado son: cantidad en cuadrado " + modelo.getCantEnCuadrado() + "\n cantidad en circulo: " + modelo.getCantEnCirculo());
        panelResultado.add(txtR);
        JFrame frame2 = new JFrame("Simulacion de arroz");
        frame2.setLayout(null);
        frame2.setSize(1100, 500);
        frame2.setResizable(false);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame2.add(panelResultado);


        JLabel labelCuadrado = new JLabel(new ImageIcon("ar/edu/unlu/mstd/cuadrado-222x201.png"));
        labelCuadrado.setBounds(0,0,500,500);



        JLabel labelCirculo = new JLabel(new ImageIcon("ar/edu/unlu/mstd/circulo.png"));
        labelCirculo.setBounds(0,0,500,500);

        JLayeredPane layeredPane1 = new JLayeredPane();
        layeredPane1.setBounds(0,0,500,500);
        layeredPane1.add(labelCirculo,0);

        for (int i = 0; i < modelo.getCantEnCirculo(); i++) {
            JLabel labelA = new JLabel("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
            labelA.setBounds(0,0,500,500);
            //labelA.setAlignmentX((float) modelo.getProbArrozCirculo(i));
            //labelA.setAlignmentY((float) modelo.getProbArrozCirculo(i));
            layeredPane1.add(labelA,i++);
        }
        JLayeredPane layeredPane2 = new JLayeredPane();
        layeredPane2.add(labelCuadrado,0);
        layeredPane2.setBounds(0,0,500,500);
        layeredPane1.add(layeredPane2,layeredPane1.highestLayer()+1);
        for (int i = 0; i < modelo.getCantEnCuadrado(); i++) {
            JLabel labelA = new JLabel("a");
            labelA.setBounds(0,0,500,500);
            //x = (int) modelo.getProbArrozCuadrado(i) * (panelCuadrado.getWidth() - labelA.getWidth());
            //y = (int) modelo.getProbArrozCuadrado(i) * (panelCuadrado.getHeight() - labelA.getHeight());
            //labelA.setLocation(x,y);
            layeredPane1.add(labelA,i++);
        }


        frame2.add(layeredPane1);
        //panelCarta.remove(panelPrincipal);
    }

    public static void main(String[] args){
        new Ventana();
    }
}
