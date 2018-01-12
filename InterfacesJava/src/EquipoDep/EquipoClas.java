/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoDep;

/**
 *
 * @author Antonio
 */
public class EquipoClas {
    private Equipo equipo;
    private int pJugados, pGanados, pEmpatados, pPerdidos, gFavor, gContra, dGoles, puntos;
    
    public EquipoClas(){
        pGanados = pEmpatados = pPerdidos = gFavor = gContra = dGoles = puntos = 0;
    }
    public EquipoClas(Equipo e){
        this();
        this.equipo = e;
    }
    public int getPuntos(){
        return this.puntos;
    }
    public int getJugados(){
        return pJugados;
    }
    public int getGanados(){
        return pGanados;
    }
    public int getPerdidos(){
        return pPerdidos;
    }
    public int getEmpatados(){
        return pEmpatados;
    }
    public int getGFavor(){
        return gFavor;
    }
    public int getGContra(){
        return gContra;
    }
    public int getDGoles(){
        return dGoles;
    }
    public Equipo getEquipo(){
        return equipo;
    }
    
    public void setPuntos(int i){
        puntos = i;
    }
    public void setPuntos(){
        puntos = pGanados * 3 + pEmpatados;
    }
    public void setJugados(int i){
        pJugados = i;
    }
    public void setJugados(){
        pJugados = pGanados + pEmpatados + pPerdidos;
    }
    public void setGanados(int i){
        pGanados = i;
    }
    public void setPerdidos(int i){
        pPerdidos = i;
    }
    public void setEmpatados(int i){
        pEmpatados = i;
    }
    public void setGFavor(int i){
        gFavor = i;
    }
    public void setGContra(int i){
        gContra = i;
    }
    public void setDGoles(int i){
        dGoles = i;
    }
    public void setDGoles(){
        dGoles = gFavor - gContra;
    }
    public void setEquipo(Equipo e){
        equipo = e;
    }
    
    public String toString(){
        String s = equipo.getNombre();
        for (int i = 0; i<(27 - equipo.getNombre().length()); i++){
            s += " ";
        }
        s = espacios(s, pJugados);
        s = espacios(s, pGanados);
        s = espacios(s, pEmpatados);
        s = espacios(s, pPerdidos);
        s = espacios(s, gFavor);
        s = espacios(s, gContra);
        s = espacios(s, dGoles);
        s = espacios(s, puntos);
        return s;
    }
    public String espacios (String s, int n){
        int space = 1;
        for (int i = n; i!=0; i = i/10){
            space += 1;
        }
       if (n/10 == 0) space +=2;
        s += n;
        
        for (int i = 0; i<space; i++){
            s += " ";
        }
        return s;
    }
    public boolean equals (EquipoClas e){
        return this.equipo.equals(e.equipo);
    }
}
