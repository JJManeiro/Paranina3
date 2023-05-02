/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin33;

/**
 *
 * @author dam1
 */
public class Futbolistas extends Seleccion {
    String marca;
    int dorsal;
    public void entrevista(){
        System.out.println("Os xogadores falan das suas vidas");
    }
    @Override
    public void entrenar() {
        System.out.println("Os xogadores se esforzan nos simulacros e outros exercicios.");
    }

    @Override
    public void viaxar() {
        System.out.println("Eles se van co entrenador ao estadio.");
    }

    @Override
    public void concentrarse() {
        System.out.println("Os xogadores o están dando todo.");
    }

    @Override
    public void xogar() {
        System.out.println("estan conversando sobre como foi o partido.");
    }    
    public Futbolistas(String nombre, String apellido,int edad,int id,int dorsal, String marca) {
        super(nombre, apellido, id, edad);
        this.marca = marca;
        this.dorsal = dorsal;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    @Override
    public String toString() {
        System.out.println("O xogador escollido foi: "+nombre+" "+apellido
                +" de idade "+edad+" coa id "+id
                +".\nTen a dorsal co numero "+dorsal+" da marca "+marca);
        return null;
    }
}
