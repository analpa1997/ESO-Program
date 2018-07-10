/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoDep;
import java.util.*;
/**
 *
 * @author Antonio
 */
public class Seleccion implements Comparable <Seleccion> {
    private String abreviatura;
    private ArrayList <Jugador> jugadores = new ArrayList();
    
    public Seleccion(String abrev, ArrayList<Jugador> roster){
        abreviatura = abrev;
        jugadores = roster;
    }
    public Seleccion(ArrayList <Jugador> roster){
        this("", roster);
    }
    public Seleccion(String abrev){
        this(abrev, new ArrayList());
    }
    public Seleccion(){
        
    }
    
    public ArrayList <Jugador> getJugadores(){
        return jugadores;
    }
    
    public void setJugadores(ArrayList <Jugador> roster){
        jugadores = roster;
    }
    public String getAbrev(){
        return this.abreviatura;
    }
    public void setAbrev (String abreviaturaNueva){
        this.abreviatura = abreviaturaNueva;
    }
    public void añadirJugador(Jugador j){
        this.jugadores.add(j);
    }
    public void ordenarRoster(){
        Collections.sort(this.jugadores, new CompareJugadores());
    }
    private String obtenerCabeceraHTML (){
        String cabecera = new String ();
        cabecera = "<pre>Name         Age Nat St Tk Ps Sh Ag KAb TAb PAb SAb Gam Sub  Min Mom Sav Con Ktk Kps Sht Gls Ass  DP Inj Sus Fit";
        cabecera = cabecera + "\n----------------------------------------------------------------------------------------------------------------\n";
        return cabecera;
    }
    public String escribirHTML(){
       String equipo = new String();
       equipo = "Abreviatura: " + this.abreviatura + "<br><br>";
       equipo = equipo + this.obtenerCabeceraHTML();
       for (Jugador j : this.jugadores){
           equipo = equipo + j.toString() + "<br>";
       }
       equipo = equipo + "</pre>";
       return equipo;
    }
    public boolean estaJugador (Jugador j2){
        boolean resultado = false;
        Iterator it = this.jugadores.iterator();
        while (it.hasNext() && !resultado){
            Jugador j1 = (Jugador) it.next();
            if(j1.equals(j2)){
                resultado = true;
            }
        }
        return resultado;
    }
    public int compareTo (Seleccion s){
        return this.getAbrev().toLowerCase().compareTo(s.getAbrev().toLowerCase());
    }
}
