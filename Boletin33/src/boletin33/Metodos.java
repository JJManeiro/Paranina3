/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boletin33;
/**
 *
 * @author dam1
 */
public class Metodos {
    public void SXogador(){
        Futbolistas Fe = new Futbolistas("Juan","ElCaballo",2,3,4,"Gucci");
        Seleccion F = new Futbolistas(Fe.getNombre(),Fe.getApellido(),Fe.getEdad(),Fe.getId(),Fe.getDorsal(),Fe.getMarca());
        F.toString();
        F.entrenar();
        F.concentrarse();
        F.xogar();
        F.viaxar();
        Fe.entrevista();
    }    
    public void SCoach(){
        Entrenadores En = new Entrenadores("Winda","Lobo",3,4,1);
        Seleccion E = new Entrenadores(En.getNombre(),En.getApellido(),En.getEdad(),En.getId(),En.getFederacion());
        E.toString();
        E.entrenar();
        E.concentrarse();
        E.xogar();
        E.viaxar();
    }
    public void SMasaxe(){
        Masajistas Ma = new Masajistas("Heather","Smith",5,6,"Floptropican",7);
        Seleccion M = new Masajistas(Ma.getNombre(),Ma.getApellido(),Ma.getEdad(),Ma.getId(),Ma.getTitulo(),Ma.getAnhos());
        M.toString();
        M.viaxar();
        M.entrenar();
        Ma.masaje();
        M.concentrarse();
        M.xogar();
    }
}
