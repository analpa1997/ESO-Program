/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizador.Data;
import java.util.ArrayList;
import java.io.*;
import java.util.Collections;
import java.util.Iterator;
/**
 *
 * @author Antonio
 */
public class Equipo {
    private String nombre;
    private String abreviatura;
    private ArrayList <Jugador> jugadores = new ArrayList();
    private double potencial, edadMedia, rendimiento;
    private int salario;
    private double elo;
    
    public Equipo (String nombre, String abrev){
        this.nombre = nombre;
        this.abreviatura = abrev;
    }
    public Equipo (String nombre, String abrev, ArrayList <Jugador> roster){
        this(nombre, abrev);
        this.jugadores = roster;
    }
    public Equipo (String abrev, ArrayList<Jugador> roster){
        this("", abrev);
        this.jugadores = roster;
    }
    public Equipo (String abrev){
        this("", abrev);
    }
    public Equipo (ArrayList<Jugador> roster){
        this.jugadores = roster;
    }
    public Equipo (){
        this.elo = 2000;
    }
    
    public double getElo (){
        return this.elo;
    }
    public double getRendimiento(){
        return this.rendimiento;
    }
    public double getPotencial(){
        return this.potencial;
    }
    public double getEdadMedia(){
        return this.edadMedia;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getAbrev(){
        return this.abreviatura;
    }
    public ArrayList <Jugador> getRoster(){
        return this.jugadores;
    }
    public int getSalario(){
        return this.salario;
    }
    public void setElo (double eloN){
        this.elo = eloN;
    }
    public void setSalario (int salarioN){
        this.salario = salarioN;
    }
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setAbrev (String abrev){
        this.abreviatura = abrev;
    }
    public void setRoster (ArrayList <Jugador> roster){
        this.jugadores = roster;
    }
    public void anadirJugador(Jugador j){
        this.jugadores.add(j);
    }
    public void escribirEquipo() throws UnsupportedEncodingException, FileNotFoundException{
        String nombreFichero = this.abreviatura + ".txt";
        OutputStreamWriter prueba = new OutputStreamWriter(new FileOutputStream(nombreFichero), "ISO-8859-1");
        BufferedWriter bw = new BufferedWriter(prueba);
        PrintWriter pw = new PrintWriter(bw);
        escribirCabecera(pw);
        for (Jugador j : this.jugadores){
            pw.println(j.toString());
        }
        pw.close();
    }
    private void escribirCabecera (PrintWriter pw){
        pw.println("Name         Age Nat St Tk Ps Sh Ag KAb TAb PAb SAb Gam Sub  Min Mom Sav Con Ktk Kps Sht Gls Ass  DP Inj Sus Fit");
        pw.println("----------------------------------------------------------------------------------------------------------------");
    }
    private String obtenerCabecera (){
        String cabecera = new String ();
        cabecera = "Name         Age Nat St Tk Ps Sh Ag KAb TAb PAb SAb Gam Sub  Min Mom Sav Con Ktk Kps Sht Gls Ass  DP Inj Sus Fit";
        cabecera = cabecera + "\n----------------------------------------------------------------------------------------------------------------\n";
        return cabecera;
    }
    private String obtenerCabeceraHTML (){
        String cabecera = new String ();
        cabecera = "<pre>Name         Age Nat St Tk Ps Sh Ag KAb TAb PAb SAb Gam Sub  Min Mom Sav Con Ktk Kps Sht Gls Ass  DP Inj Sus Fit";
        cabecera = cabecera + "\n----------------------------------------------------------------------------------------------------------------\n";
        return cabecera;
    }
    public void ordenarRoster(){
        Collections.sort(this.getRoster(), new CompareJugadores());
    }
    public void ordenarRosterAZ(){
        Collections.sort(this.getRoster());
    }
    public String toString(){
       String equipo = new String();
       equipo = "Nombre: " + this.nombre + "\nAbreviatura: " + this.abreviatura + "\n\n";
       equipo = equipo + this.obtenerCabecera();
       for (Jugador j : this.jugadores){
           equipo = equipo + j.toString() + "\n";
       }
       equipo = equipo + "";
       return equipo;
    }
    public String escribirHTML(){
       String equipo = new String();
       equipo = "Nombre: " + this.nombre + "<br>Abreviatura: " + this.abreviatura + "<br><br>";
       equipo = equipo + this.obtenerCabeceraHTML();
       for (Jugador j : this.jugadores){
           equipo = equipo + j.toString() + "<br>";
       }
       equipo = equipo + "</pre>";
       return equipo;
    }
    public Jugador buscarJugador (String nombre){
        Iterator it = this.getRoster().iterator();
        boolean encontrado = false;
        Jugador buscado = new Jugador();
        while(it.hasNext() && !encontrado){
            buscado = (Jugador) it.next();
            if (buscado.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                encontrado = true;
            }
        }
        return buscado;
    }
    public void sumarFit(int nFit){
        for (Jugador j:this.getRoster()){
            j.sumarFit(nFit);
            j.definirPosicion();
            j.definirPosInt();
            j.definirMedias();
            j.definirSalario();
        }
    }
    public void calcularPotencial (){
        potencial = 0;
        for (Jugador j: this.getRoster()){
           potencial += j.calcularPotencial();
        }
    }
    public void calcularRendimiento (){
        rendimiento = 0;
        for (Jugador j: this.getRoster()){
           rendimiento += j.calcularRendimiento();
        }
    }
    public void calcularEdadMedia (){
        edadMedia = 0;
        for (Jugador j: this.getRoster()){
           edadMedia += j.getEdad();
        }
        edadMedia = edadMedia/this.getRoster().size();
    }
    public void calcularSalario (){
        salario = 0;
        for (Jugador j: this.getRoster()){
           salario += j.getSalario();
        }
    }
}
