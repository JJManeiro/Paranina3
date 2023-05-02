/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boletin33;

/**
 *
 * @author dam1
 */
public class Boletin33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos me = new Metodos();
        System.out.println("Hei acá a selección.");
        System.out.println("Entrenadores:");
        me.SCoach();
        System.out.println("Xogadores:");
        me.SXogador();
        System.out.println("Masaxistas:");
        me.SMasaxe();
    }
    
}
