/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import Boletin29b.Boletin29b;
import boletin29.Boletin29;
import java.util.Scanner;
/**
 *
 * @author dam1
 */
public class Cola {
    public static void main(String[] args) {
        System.out.println("Cual quieres ver? 1 para el primero,2 para el segundo.");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n==1){
            Boletin29 b29 = new Boletin29();
            b29.hola();
        }
        else if (n==2){
            Boletin29b b29b = new Boletin29b();
            b29b.ktal();
        }
    }
}
