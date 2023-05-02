/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin33;

/**
 *
 * @author dam1
 */
public class Entrenadores extends Seleccion {
    int federacion;
    public void plan(){
        System.out.println("O entrenador pon a proba aos xogadores");
    }
    @Override
    public void entrenar() {
        System.out.println("O entrenador supervisa o equipo");
    }

    @Override
    public void viaxar() {
        System.out.println("Viaxan ao estadio de futbol");
    }

    @Override
    public void concentrarse() {
        System.out.println("Poñen todo o empeño no asador");
    }

    @Override
    public void xogar() {
        System.out.println("O entrenador decide meterse no medio por divertirse.");
    }

    public Entrenadores(String nombre, String apellido, int edad, int id, int federacion) {
        super(nombre, apellido, id, edad);
        this.federacion = federacion;
    }

    public int getFederacion() {
        return federacion;
    }

    public void setFederacion(int federacion) {
        this.federacion = federacion;
    }

    @Override
    public String toString() {
        System.out.println("O entrenador escollido foi: "+nombre+" "+apellido
                +" de idade "+edad+" coa id "+id
                +".\nProvén da federación numero "+federacion);
        return null;
    }
}
