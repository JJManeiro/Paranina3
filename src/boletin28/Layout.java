/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin28;
import java.awt.GridLayout;
import javax.swing.*;
/**
 *
 * @author dam1
 */
public class Layout {
    JFrame marco;
    JPanel panel;
    JLabel tag,t2;
    JTextField linea;
    JPasswordField l2;
    JTextArea texto;
    JButton premer,limpar;
    public void init(){
        marco = new JFrame("Boletin 28");
        panel = new JPanel();
        tag = new JLabel("Nome");
        t2 = new JLabel("Contrasinal");
        linea = new JTextField();
        l2 = new JPasswordField();
        texto = new JTextArea("Area de texto.");
        premer = new JButton("Premer");
        limpar = new JButton("Limpar");
    }
    public void layout(){
        init();
        panel.setLayout(null);
        panel.add(tag);
        tag.setBounds(100, 50, 100, 50);
        panel.add(t2);
        t2.setBounds(100, 150, 100, 50);
        panel.add(linea);
        linea.setBounds(300,50,300,70);
        panel.add(l2);
        l2.setEchoChar('*');
        l2.setBounds(300, 150, 300, 70);
        panel.add(texto);
        texto.setBounds(100, 300, 450, 150);
        panel.add(premer);
        premer.setBounds(130, 550, 210, 70);
        panel.add(limpar);
        limpar.setBounds(400,550,210,70);
        marco.add(panel);
        panel.setBounds(0, 0, 800, 600);
        marco.setLocationRelativeTo(panel);
        marco.setSize(1000, 800);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}
