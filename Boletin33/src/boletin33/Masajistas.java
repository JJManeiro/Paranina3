/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin33;

/**
 *
 * @author dam1
 */
public class Masajistas extends Seleccion {
    String titulo;
    int anhos;
    public void masaje(){
        System.out.println("Os masaxistas dan un masaxe aos cansados");
    }

    @Override
    public void entrenar() {
        System.out.println("Fan prácticas sobre o uso da carta de nervios e un moneco.");
    }

    @Override
    public void viaxar() {
        System.out.println("Van cos xogadores para o estadio.");
    }

    @Override
    public void concentrarse() {
        System.out.println("Están comfortando os xogadores.");
    }

    @Override
    public void xogar() {
        System.out.println("Están charlando cos xogadores sobre o seu dia a dia.");
    }
    public Masajistas(String nombre, String apellido,int edad,int id,String titulo, int anhos) {
        super(nombre, apellido, id, edad);
        this.titulo = titulo;
        this.anhos = anhos;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnhos() {
        return anhos;
    }

    public void setAnhos(int anhos) {
        this.anhos = anhos;
    }

    @Override
    public String toString() {
        System.out.println("O masaxista escollido foi: "+nombre+" "+apellido
                +" de idade "+edad+" coa id "+id
                +".\nTen o titulo de "+titulo+" e leva "+anhos+" anos de experiencia.");
        return null;
    }
}
