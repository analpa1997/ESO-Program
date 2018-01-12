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
public class Resultado {
    private Equipo local, visitante;
    private int resLocal, resVisitante;
    
    public Resultado(){
        
    }
    public Resultado(Equipo l, Equipo v, int rLocal, int rVisitante){
        local = l;
        visitante = v;
        resLocal = rLocal;
        resVisitante = rVisitante;
    }
    
    public Equipo getLocal(){
        return local;
    } 
    public Equipo getVisitante(){
        return visitante;
    }
    public int getResLocal (){
        return resLocal;
    }
    public int getResVisitante(){
        return resVisitante;
    }
    public void setLocal (Equipo e){
        local = e;
    }
    public void setVisitante (Equipo e){
        visitante = e;
    }
    public void setResLocal (int r){
        resLocal = r;
    }
    public void setResVisitante (int r){
        resVisitante = r;
    }
}
